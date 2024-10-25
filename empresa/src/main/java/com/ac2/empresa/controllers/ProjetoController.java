package com.ac2.empresa.controllers;

import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.dtos.ThunderDTOPRojeto;
import com.ac2.empresa.models.Projeto;
import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.services.ProjetoServiceImp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;



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
    public List<Projeto> dadosAndFuncionariosDoProjeto(@RequestBody ThunderDTOPRojeto dto) {
        List<Projeto> projetos = projetoServiceImp.dadosAndFuncionariosDoProjeto(dto.projetoid());

        return projetos;
    }

    @GetMapping("/datainicio")
    public List<Projeto> projetoPorData(@RequestBody Integer projetoid, LocalDate projetodatainicio, LocalDate projetodatafim) {
        List<Projeto> projetosData = projetoServiceImp.projetoPordata(projetoid, projetodatainicio, projetodatafim);

        return projetosData;
    }
    
    
}
