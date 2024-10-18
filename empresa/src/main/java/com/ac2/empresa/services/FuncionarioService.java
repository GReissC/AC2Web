package com.ac2.empresa.services;


import com.ac2.empresa.dtos.FuncionarioDTO;

public interface FuncionarioService {

    void salvar(FuncionarioDTO funcionarioDTO);
    void obterTodos();
    void editar(Integer funcionarioid, FuncionarioDTO funcionarioDTO);
    void deletar(Integer funcionarioid);
    
    
}
