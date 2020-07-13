package br.com.example.loja.controller.dto;

import java.util.List;

public class CompraDTO {

    private List<ItemDaCompraDTO> itens;

    private EnderecoDTO endereco;

    public List<ItemDaCompraDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDaCompraDTO> itens) {
        this.itens = itens;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "CompraDTO{" +
                "itens=" + itens +
                ", endereco=" + endereco +
                '}';
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
