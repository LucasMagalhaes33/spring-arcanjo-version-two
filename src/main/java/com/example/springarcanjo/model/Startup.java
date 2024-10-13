package com.example.springarcanjo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "STARTUP")
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;

    private String nome;
    private String setor;
    private double percentualDisponivel;
    private double valorProcurado;

    private int votos;
}
