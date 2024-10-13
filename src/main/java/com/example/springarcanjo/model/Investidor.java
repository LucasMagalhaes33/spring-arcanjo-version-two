package com.example.springarcanjo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "INVESTIDOR")
public class Investidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investidor")
    private Long id;

    private String nome;
    private String setorInteresse;
}