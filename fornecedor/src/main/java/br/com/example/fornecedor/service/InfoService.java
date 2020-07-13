package br.com.example.fornecedor.service;

import br.com.example.fornecedor.model.InfoFornecedor;
import br.com.example.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado) {

        return infoRepository.findByEstado(estado);
    }
}
