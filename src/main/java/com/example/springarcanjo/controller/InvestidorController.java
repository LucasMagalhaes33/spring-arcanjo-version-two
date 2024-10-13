package com.example.springarcanjo.controller;

import com.example.springarcanjo.model.Investidor;
import com.example.springarcanjo.model.Startup;
import com.example.springarcanjo.repository.InvestidorRepository;
import com.example.springarcanjo.repository.StartupRepository;
import com.example.springarcanjo.service.RecomendacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = {"startups"})
public class InvestidorController {

    @Autowired
    private InvestidorRepository investidorRepository;

    @Autowired
    private StartupRepository startupRepository;

    @Autowired
    private RecomendacaoService recomendacaoService;

    @GetMapping("/cadastro/investidor")
    public String showCadastroInvestidorForm() {
        return "cadastro_investidor";
    }

    // Cadastro de Investidor
    @PostMapping("/cadastro/investidor")
    public String cadastrarInvestidor(
            @RequestParam String nome,
            @RequestParam String setorInteresse,
            Model model) {

        Investidor investidor = new Investidor();
        investidor.setNome(nome);
        investidor.setSetorInteresse(setorInteresse);

        investidorRepository.save(investidor);

        model.addAttribute("message", "Investidor cadastrado com sucesso!");
        return "cadastro_investidor";
    }

    // Sistema de recomendação
    @GetMapping("/recomendacao")
    public List<Startup> recomendarStartups(@RequestParam Long investidorId, Model model) {
        Investidor investidor = investidorRepository.findById(investidorId).orElse(null);
        if (investidor != null) {
            // Busca startups com mais likes
            List<Startup> startupsPopulares = startupRepository.findAllByOrderByVotosDesc();

            // Filtra as startups pelo setor de interesse do investidor
            return startupsPopulares.stream()
                    .filter(s -> s.getSetor().equalsIgnoreCase(investidor.getSetorInteresse()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @GetMapping("/recomendacaoPython")
    public List<Startup> recomendacaoPython(@RequestParam Long investidorId, Model model) {
       return recomendacaoService.retornaStartups(investidorId);
    }

}