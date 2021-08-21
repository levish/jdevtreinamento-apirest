package com.jdev.crudtreinamento.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    private String nome;

    private int idade;
}
