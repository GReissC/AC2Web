package com.ac2.empresa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.services.ProjetoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/empresa/Projeto")
public class ProjetoController {
    @Autowired
    private ProjetoServiceImp projetoServiceImp;

    @PostMapping
    public void saveFuncionario(@RequestBody ProjetoDTO dto) {
        projetoServiceImp.salvar(dto);
    }

    @PostMapping
    public void obterTodos(@RequestBody ProjetoDTO projetoDTO) {
        projetoServiceImp.obterTodos();
        
    }

    @PostMapping
    public void updateProjeto(@RequestBody Integer projetoid, ProjetoDTO projetoDTO) {
        projetoServiceImp.editar(projetoid, projetoDTO);  
    }

    @PostMapping
    public void deleteProjeto(@RequestBody Integer projetoid) {
        projetoServiceImp.deletar(projetoid);
    }
    
}
