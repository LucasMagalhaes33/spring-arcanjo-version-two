package com.example.springarcanjo.feign;

import com.example.springarcanjo.model.RecomendacaoResponse;
import com.example.springarcanjo.model.Startup;
import com.example.springarcanjo.model.StartupMetadados;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "recomendacaoClient", url = "http://54.84.105.130:5000")
public interface RecomendacaoClient {

    @GetMapping("/recomendacao/{investidorId}")
    RecomendacaoResponse recomendacao(@PathVariable Long investidorId);
}
