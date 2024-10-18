package com.ac2.empresa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Setor {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer setorid;
    private String setornome;
    
    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionariosetor;
}
