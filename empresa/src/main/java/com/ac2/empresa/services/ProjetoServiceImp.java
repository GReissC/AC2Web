package com.ac2.empresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.models.Projeto;
import com.ac2.empresa.repositories.ProjetoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImp implements ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

    @Override
    public void salvar(ProjetoDTO projetoDTO) {
        Projeto projetocriado = new Projeto(projetoDTO.getProjetoiddto(), projetoDTO.getProjetodescricaodto(), 
        projetoDTO.getProjetodatainiciodto(), projetoDTO.getProjetodatafimdto(),null);
        projetoRepository.save(projetocriado);

    }

    @Override
    public void obterTodos() {
        projetoRepository.findAll();
    }

    @Override
    public void editar(Integer projetoid, ProjetoDTO projetoDTO) {
        Projeto projetoeditado = projetoRepository.getReferenceById(projetoid);
        projetoeditado.setProjetodescricao(projetoDTO.getProjetodescricaodto());
        projetoeditado.setProjetodatainicio(projetoDTO.getProjetodatainiciodto());
        projetoeditado.setProjetodatafim(projetoDTO.getProjetodatafimdto());
        projetoeditado.setFuncionarios(null);
        projetoRepository.save(projetoeditado);

    }

    @Override
    public void deletar(Integer projetoid) {
        Projeto projetodeletado = projetoRepository.getReferenceById(projetoid);
        projetoRepository.delete(projetodeletado);
    }

}
