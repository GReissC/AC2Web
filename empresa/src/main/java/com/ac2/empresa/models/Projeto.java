package com.ac2.empresa.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer projetoid;
    private String projetodescricao;
    private LocalDate projetodatainicio;
    private LocalDate projetodatafim;
    

    @ManyToMany()
    @JoinTable(name= "Relacao projeto-funcionario",
                joinColumns =  @JoinColumn(name= "projetoid"),
                inverseJoinColumns =  @JoinColumn(name= "funcionarioid")

    )
    private List<Funcionario> funcionarios;

    public Projeto(String projetodescricao, LocalDate projetodatainicio, LocalDate projetodatafim){
        this.projetodescricao = projetodescricao;
        this.projetodatainicio = projetodatainicio;
        this.projetodatafim = projetodatafim;
    }

}
