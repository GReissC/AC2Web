package com.ac2.empresa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.services.ProjetoServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ProjetoController {
    
    @Autowired
    private ProjetoServiceImp projetoServiceImp;

    
    @PostMapping()
    public void adicionar(@RequestBody ProjetoDTO projetoDTO) {
        projetoServiceImp.salvar(projetoDTO);
    }

    
    @GetMapping()
    public void buscarProjetoPorId(@PathVariable Integer id) {
        projetoServiceImp.buscarPorId(id);
    }

    
    @PutMapping()
    public void updateProjeto(@RequestBody ProjetoDTO projetoDTO) {
        projetoServiceImp.editar(projetoDTO.getProjetoiddto(), projetoDTO);
    }

    
    @DeleteMapping()
    public void deleteProjeto(@PathVariable Integer id) {
        projetoServiceImp.deletar(id);
    }

    
    @PostMapping()
    public void vincularFuncionario(@RequestBody FuncionarioDTO FuncionarioDTO) {
        projetoServiceImp.vincularFuncionario(FuncionarioDTO.getIdProjeto(), FuncionarioDTO.getIdFuncionario());
    }
}
