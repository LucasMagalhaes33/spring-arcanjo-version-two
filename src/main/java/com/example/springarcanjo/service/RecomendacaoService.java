package com.example.springarcanjo.service;

import com.example.springarcanjo.feign.RecomendacaoClient;
import com.example.springarcanjo.model.RecomendacaoResponse;
import com.example.springarcanjo.model.Startup;
import com.example.springarcanjo.model.StartupMetadados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoService {

    @Autowired
    private RecomendacaoClient recomendacaoClient;

    public RecomendacaoResponse retornaStartups(Long investidorId) {
        return recomendacaoClient.recomendacao(investidorId);
    }

}

