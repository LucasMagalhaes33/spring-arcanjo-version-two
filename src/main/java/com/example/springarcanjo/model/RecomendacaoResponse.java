package com.example.springarcanjo.model;

import java.util.List;

public class RecomendacaoResponse {
    private Long investidor_id;
    private List<Integer> startups_recomendadas;

    // Getters e Setters
    public Long getInvestidor_id() {
        return investidor_id;
    }

    public void setInvestidor_id(Long investidor_id) {
        this.investidor_id = investidor_id;
    }

    public List<Integer> getStartups_recomendadas() {
        return startups_recomendadas;
    }

    public void setStartups_recomendadas(List<Integer> startups_recomendadas) {
        this.startups_recomendadas = startups_recomendadas;
    }
}

