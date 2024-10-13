package com.example.springarcanjo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PROPOSTA")
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "startup_id")
    private Startup startup;

    @ManyToOne
    @JoinColumn(name = "investidor_id")
    private Investidor investidor;
}
