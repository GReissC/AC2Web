package com.ac2.empresa.services;


import java.time.LocalDate;
import java.util.List;

import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.models.Projeto;

public interface ProjetoService {

    void salvar (ProjetoDTO projetoDTO);
    void obterTodos();
    void editar(Integer projetoid, ProjetoDTO projetoDTO);
    void deletar(Integer projetoid);
    void buscarPorId(Integer projetoid);
    List<Projeto> dadosAndFuncionariosDoProjeto(Integer projetoid);
    List<Projeto> projetoPordata(LocalDate projetodatainicio, LocalDate projetodatafim);

}
