package com.ac2.empresa.services;


import com.ac2.empresa.dtos.SetorDTO;

public interface SetorService {

    void salvar(SetorDTO setorDTO);
    void obterTodos();
    void editar(Integer setorid, SetorDTO setorDTO);
    void deletar(Integer setorid);
    
}
