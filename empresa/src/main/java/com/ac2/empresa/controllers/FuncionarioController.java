package com.ac2.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.services.FuncionarioServiceImp;

@RestController
@RequestMapping("/empresa/Funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImp funcionarioServiceImp;

    @PostMapping
    public void saveFuncionario(@RequestBody FuncionarioDTO dto) {
        funcionarioServiceImp.salvar(dto);
    }

    @PostMapping
    public void obterTodos(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioServiceImp.obterTodos();
        
    }

    @PostMapping
    public void updateFuncionario(@RequestBody Integer funcionarioid, FuncionarioDTO funcionarioDTO) {
        funcionarioServiceImp.editar(funcionarioid, funcionarioDTO);  
    }

    @PostMapping
    public void deleteFuncionario(@RequestBody Integer funcionarioid) {
        funcionarioServiceImp.deletar(funcionarioid);
    }
    
    
}
