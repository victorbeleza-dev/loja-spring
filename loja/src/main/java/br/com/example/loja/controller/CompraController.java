package br.com.example.loja.controller;


import br.com.example.loja.controller.dto.CompraDTO;
import br.com.example.loja.model.Compra;
import br.com.example.loja.service.CompraService;
import org.apache.catalina.realm.CombinedRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @RequestMapping(method = RequestMethod.POST)
    public Compra realizaCompra(@RequestBody CompraDTO compra){
        return compraService.realizaCompra(compra);
    }
}
