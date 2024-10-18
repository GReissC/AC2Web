package com.ac2.empresa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer funcionarioid;
    private String funcionarionome;

    @ManyToMany(mappedBy = "funcionarios")
    private List<Projeto> projetos;

    @ManyToOne()
    @JoinColumn(name = "setorid")
    private Setor setor;

}
