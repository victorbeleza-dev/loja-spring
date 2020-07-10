package br.com.example.loja.service;

import br.com.example.loja.client.FornecedorClient;
import br.com.example.loja.controller.dto.CompraDTO;
import br.com.example.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public void realizaCompra(CompraDTO compra) {

        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        System.out.println(info.getEndereco());
    }

}
