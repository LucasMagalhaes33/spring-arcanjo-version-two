package com.example.springarcanjo.repository;

import com.example.springarcanjo.model.Startup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long> {

    // Ordena por número de likes de forma decrescente
    List<Startup> findAllByOrderByVotosDesc();
}
