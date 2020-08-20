package com.regis.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.regis.jwt.dto.UsuarioDTO;
import com.regis.jwt.model.Usuario;
import com.regis.jwt.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/autenticar")
	public UsuarioDTO autenticar(@RequestBody Usuario usuario) {
		try {
			UsuarioDTO usuarioDto = usuarioService.autenticar(usuario);
			
			return usuarioDto;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	
	@GetMapping(value = "")
	public void teste() {
		System.out.println("Teste usuarios");
	}
	
}
