package com.ac2.empresa.dtos.dtoRequest;

import java.util.List;

import com.ac2.empresa.dtos.SetorDTO;

import lombok.Builder;

@Builder
public record ThunderDTO3D(List<SetorDTO> setorDTO) {
    
}
