package com.ac2.empresa.services;



import java.util.List;

import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.models.Funcionario;

public interface FuncionarioService {

    void salvar(FuncionarioDTO funcionarioDTO);
    void obterTodos();
    void editar(Integer funcionarioid, FuncionarioDTO funcionarioDTO);
    void deletar(Integer funcionarioid);
    List<Funcionario> projetosEnvolvidos(Integer funcionarioid);
    
}
