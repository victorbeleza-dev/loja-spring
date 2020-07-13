package br.com.example.loja.service;

import br.com.example.loja.client.FornecedorClient;
import br.com.example.loja.controller.dto.CompraDTO;
import br.com.example.loja.controller.dto.InfoFornecedorDTO;
import br.com.example.loja.controller.dto.InfoPedidoDTO;
import br.com.example.loja.controller.dto.ItemDaCompraDTO;
import br.com.example.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {

        final String estado = compra.getEndereco().getEstado();

        LOG.info("buscando informações do fornecedor de " +estado);
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        LOG.info("realizando pedido");
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

        Compra compraR = new Compra();
        compraR.setPedidoId(pedido.getId());
        compraR.setTempoDePreparo(pedido.getTempoDePreparo());
        compraR.setEnderecoDestino(compra.getEndereco().toString());

        return compraR;
    }

}
