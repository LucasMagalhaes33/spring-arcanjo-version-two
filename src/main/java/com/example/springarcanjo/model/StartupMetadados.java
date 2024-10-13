package com.example.springarcanjo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "STARTUP_METADADO")
@Data
public class StartupMetadados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_empresa")
    private Startup startup;

    @Column(name = "votos")
    private int votos;
}
