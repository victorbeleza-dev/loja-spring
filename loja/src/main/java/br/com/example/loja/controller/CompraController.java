package br.com.example.loja.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

	@ApiOperation(value = "Retorna o pedido pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o pedido"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@RequestMapping(value = "/{id}",method = RequestMethod.GET, produces="application/json")
	public Compra getById(@PathVariable("id") Long id) {
		return compraService.getById(id);
	}

	@ApiOperation(value = "Realiza uma compra")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o pedido"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return compraService.realizaCompra(compra);
	}
}
