package com.otavio.voleimanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "volei_time")
public class Time {

    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String cidade;

    @Column(length = 50, nullable = false)
    private String estado;
}
