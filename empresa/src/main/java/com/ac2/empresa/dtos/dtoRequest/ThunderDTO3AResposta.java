package com.ac2.empresa.dtos.dtoRequest;

import java.util.List;

import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.dtos.ProjetoDTO;

import lombok.Builder;

@Builder
public record ThunderDTO3AResposta(ProjetoDTO projeto, List<FuncionarioDTO> funcionario) {
    
}
