package br.com.example.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.loja.dto.CompraDTO;
import br.com.example.loja.model.Compra;
import br.com.example.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping("/{id}")
	public Compra getById(@PathVariable("id") Long id) {
		return compraService.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return compraService.realizaCompra(compra);
	}
}
