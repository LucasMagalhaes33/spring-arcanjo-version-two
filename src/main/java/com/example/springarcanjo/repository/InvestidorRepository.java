package com.example.springarcanjo.repository;

import com.example.springarcanjo.model.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, Long> {
}
