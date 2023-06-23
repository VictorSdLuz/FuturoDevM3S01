package com.senai.devinadoption.model;

import com.senai.devinadoption.enums.Animal;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Animal animal;

    @Column(columnDefinition = "boolean default false")
    private boolean ativo;
}