package com.ac2.empresa.services;


import java.util.List;

import com.ac2.empresa.dtos.SetorDTO;
import com.ac2.empresa.models.Setor;

public interface SetorService {

    void salvar(SetorDTO setorDTO);
    void obterTodos();
    void editar(Integer setorid, SetorDTO setorDTO);
    void deletar(Integer setorid);
    void buscarPorId(Integer setorid);
    List<Setor> buscarFuncionarios(Integer setorid);
}
