package com.regis.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.regis.jwt.dto.UsuarioDTO;
import com.regis.jwt.model.Usuario;
import com.regis.jwt.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JwtService jwtService;
	
	private UsuarioDTO usuarioDto;
	
	public UsuarioDTO autenticar(Usuario usuario) {
		Usuario usuarioBanco = retornaUsuarioBanco(usuario.getUsuario());
		
		if (usuario.getSenha().equals(usuarioBanco.getSenha())) {
			String token = jwtService.gerarToken(usuario);
			usuarioDto.setToken(token);
			
			return usuarioDto;
		}
		
		return null;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = retornaUsuarioBanco(username);
		
		return User.builder()
				.username(usuario.getUsuario())
				.password(usuario.getSenha())
				.roles("ADMIN")
				.build();
	}
	
	public Usuario retornaUsuarioBanco(String username) {
		Usuario usuario = usuarioRepository.findByUsuario(username);

		usuarioDto = new UsuarioDTO(usuario);
		
		return usuario;
	}
	
}
