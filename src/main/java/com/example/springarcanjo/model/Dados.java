package com.example.springarcanjo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "DADOS")
@Data
public class Dados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dados_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_investidor", nullable = false)
    private Investidor investidor;

    @Column(name = "avaliacao")
    private int avaliacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Startup startupMetadado;
}
