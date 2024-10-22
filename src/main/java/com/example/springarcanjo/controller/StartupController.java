package com.example.springarcanjo.controller;

import com.example.springarcanjo.model.Startup;
import com.example.springarcanjo.repository.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping(value = {"startups"})
public class StartupController {
    @Autowired
    private StartupRepository startupRepository;

    @GetMapping
    public List<Startup> showCadastroForm() {
        return startupRepository.findAll();
    }

    @PostMapping("/cadastro/startup")
    public String cadastrarStartup(
            @RequestParam String nome,
            @RequestParam String setor,
            @RequestParam double percentualDisponivel,
            @RequestParam double valorProcurado,
            Model model) {

        Startup startup = new Startup();
        startup.setNome(nome);
        startup.setSetor(setor);
        startup.setPercentualDisponivel(percentualDisponivel);
        startup.setValorProcurado(valorProcurado);
        startup.setVotos(0);

        startupRepository.save(startup);

        model.addAttribute("message", "Startup cadastrada com sucesso!");
        return "cadastro_startup";
    }

    // Adiciona um like à startup
    @PostMapping("/startup/like")
    public String likeStartup(@RequestParam Long startupId, Model model) {
        Startup startup = startupRepository.findById(startupId).orElse(null);
        if (startup != null) {
            startup.setVotos(startup.getVotos() + 1);
            startupRepository.save(startup);
        }
        return "redirect:/recomendacao";
    }

    @GetMapping("/{id}")
    public Startup getStartupById(@PathVariable Long id) {
        return startupRepository.findById(id).orElse(null);
    }


}
