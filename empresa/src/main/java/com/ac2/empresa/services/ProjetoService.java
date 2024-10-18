package com.ac2.empresa.services;


import com.ac2.empresa.dtos.ProjetoDTO;

public interface ProjetoService {

    void salvar (ProjetoDTO projetoDTO);
    void obterTodos();
    void editar(Integer projetoid, ProjetoDTO projetoDTO);
    void deletar(Integer projetoid);

}
