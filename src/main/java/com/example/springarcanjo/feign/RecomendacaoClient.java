package com.example.springarcanjo.feign;

import com.example.springarcanjo.model.Startup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "recomendacaoClient", url = "http://localhost:5000")
public interface RecomendacaoClient {

    @GetMapping("/recomendacao")
    List<Startup>   recomendacao(@RequestParam Long investidorId);
}
