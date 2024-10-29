package com.ac2.empresa.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.models.Funcionario;
import com.ac2.empresa.models.Projeto;
import com.ac2.empresa.repositories.ProjetoRepository;
import com.ac2.empresa.repositories.FuncionarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImp implements ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;
    FuncionarioRepository funcionarioRepository;

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

    @Override
    public void buscarPorId(Integer projetoid) {
        projetoRepository.findById(projetoid);
    }

    @Transactional
    public void vincularFuncionario(Integer projetoid, Integer funcionarioid){
        Projeto projeto = projetoRepository.findById(projetoid)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(funcionarioid)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);

        projetoRepository.save(projeto);
    }

    @Override
    public List<Projeto> dadosAndFuncionariosDoProjeto(Integer projetoid) {
        List<Projeto> projetos = projetoRepository.query3A(projetoid);
        return projetos;
    }

    @Override
    public List<Projeto> projetoPordata(LocalDate projetodatainicio, LocalDate projetodatafim) {
        List<Projeto> projetosData = projetoRepository.query3B(null, null);
        return projetosData;
    };

}
