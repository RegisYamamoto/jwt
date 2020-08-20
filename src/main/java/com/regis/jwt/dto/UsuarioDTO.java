package com.regis.jwt.dto;

import com.regis.jwt.model.Usuario;

public class UsuarioDTO {

	private Long id;
	private String usuario;
	private String token;
	private String senha;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		this.usuario = usuario.getUsuario();
		this.senha = usuario.getSenha();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", usuario=" + usuario + ", token=" + token + ", senha=" + senha + "]";
	}

}
