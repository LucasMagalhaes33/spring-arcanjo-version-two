package com.example.springarcanjo.service;

import com.example.springarcanjo.feign.RecomendacaoClient;
import com.example.springarcanjo.model.Startup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoService {

    @Autowired
    private RecomendacaoClient recomendacaoClient;

    public List<Startup> retornaStartups(Long investidorId) {
        return recomendacaoClient.recomendacao(investidorId);
    }

}

