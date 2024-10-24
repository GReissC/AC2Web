package com.ac2.empresa.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
    
    private Integer projetoiddto;
    private String projetodescricaodto;
    private LocalDate projetodatainiciodto;
    private LocalDate projetodatafimdto;
    
}