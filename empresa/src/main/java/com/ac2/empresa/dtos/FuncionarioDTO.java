package com.ac2.empresa.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private Integer funcionarioiddto;
    private String funcionarionomedto;
    private Integer projetoid;

    public FuncionarioDTO(String funcionarionomedto) {
        this.funcionarionomedto = funcionarionomedto;
    }

    public Integer getIdProjeto() {
        return projetoid;
    }

    public Integer getIdFuncionario() {
        return funcionarioiddto;
    }
}
