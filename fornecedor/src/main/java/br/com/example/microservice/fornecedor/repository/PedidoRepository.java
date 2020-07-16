package br.com.example.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.example.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
