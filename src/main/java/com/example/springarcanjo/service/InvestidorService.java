package com.example.springarcanjo.service;

import com.example.springarcanjo.model.Investidor;
import com.example.springarcanjo.model.Startup;
import com.example.springarcanjo.repository.InvestidorRepository;
import com.example.springarcanjo.repository.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;

    @Autowired
    private StartupRepository startupRepository;

    /**
     * Encontra as 3 startups que mais combinam com o setor de interesse do investidor.
     * A recomendação é baseada no maior número de votos.
     *
     * @param investidorId O ID do investidor
     * @return Lista das top 3 startups recomendadas
     */
    public List<Startup> recomendarStartups(Long investidorId) {
        // Busca o investidor pelo ID
        Investidor investidor = investidorRepository.findById(investidorId)
                .orElseThrow(() -> new IllegalArgumentException("Investidor não encontrado"));

        // Busca as 3 startups que têm o mesmo setor de interesse, ordenadas por número de votos
        return startupRepository.findTop3BySetorOrderByVotosDesc(investidor.getSetorInteresse());
    }
}
