package com.regis.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosController {

	@GetMapping(value = "")
	public void teste() {
		System.out.println("# Teste pedidos");
	}
	
}
