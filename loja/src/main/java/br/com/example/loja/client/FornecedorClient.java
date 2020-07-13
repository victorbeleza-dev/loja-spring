package br.com.example.loja.client;

import br.com.example.loja.controller.dto.InfoFornecedorDTO;
import br.com.example.loja.controller.dto.ItemDaCompraDTO;
import br.com.example.loja.controller.dto.InfoPedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, value = "/pedido")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
