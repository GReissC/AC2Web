package com.ac2.empresa.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.dtos.dtoRequest.ThunderDTO3B;
import com.ac2.empresa.dtos.dtoRequest.ThunderDTO3A;
import com.ac2.empresa.models.Projeto;
import com.ac2.empresa.services.ProjetoServiceImp;



@RestController
@RequestMapping("/api/empresa/projetocontroller")
public class ProjetoController {
    
    @Autowired
    private ProjetoServiceImp projetoServiceImp;

    
    @PostMapping("/adicionar")
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

    
    @PostMapping("/vincular")
    public void vincularFuncionario(@RequestBody FuncionarioDTO FuncionarioDTO) {
        projetoServiceImp.vincularFuncionario(FuncionarioDTO.getIdProjeto(), FuncionarioDTO.getIdFuncionario());
    }

    @GetMapping("/tudoProjeto")
    public List<Projeto> dadosAndFuncionariosDoProjeto(@RequestBody ThunderDTO3A dto) {
        List<Projeto> projetos = projetoServiceImp.dadosAndFuncionariosDoProjeto(dto.projetoid());

        return projetos;
    }

    @GetMapping("/datainicio")
    public List<Projeto> projetoPorData(@RequestBody ThunderDTO3B dto) {
        List<Projeto> projetosData = projetoServiceImp.projetoPordata(dto.projetodatainicio(), dto.projetodatafim());

        return projetosData;
    }
    
    
}
