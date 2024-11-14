package com.ac2.empresa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.dtos.ProjetoDTO;
import com.ac2.empresa.dtos.dtoRequest.ThunderDTO3CResposta;
import com.ac2.empresa.models.Funcionario;
import com.ac2.empresa.models.Projeto;
import com.ac2.empresa.repositories.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImp implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void salvar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionariocriado = new Funcionario(funcionarioDTO.getFuncionarioiddto(),funcionarioDTO.getFuncionarionomedto(),null,null);
        funcionarioRepository.save(funcionariocriado);

    }

@Override
public void obterTodos() {
    funcionarioRepository.findAll();
}

@Override
public void editar(Integer funcionarioid, FuncionarioDTO funcionarioDTO) {
    Funcionario funcionarioeditado = funcionarioRepository.getReferenceById(funcionarioid);
    funcionarioeditado.setFuncionarionome(funcionarioDTO.getFuncionarionomedto());
    funcionarioRepository.save(funcionarioeditado);
    
}

@Override
public void deletar(Integer funcionarioid) {
    Funcionario funcionariodeletado = funcionarioRepository.getReferenceById(funcionarioid);
    funcionarioRepository.delete(funcionariodeletado);
}

@Override
public ThunderDTO3CResposta projetosEnvolvidos(Integer funcionarioid) {
    List<Projeto> projetos = funcionarioRepository.query3C(funcionarioid);
    List<ProjetoDTO> projetosDTO = projetos.stream().map((Projeto p) ->{
        return ProjetoDTO.builder()
                        .projetodescricaodto(p.getProjetodescricao())
                        .projetodatainiciodto(p.getProjetodatainicio())
                        .projetodatafimdto(p.getProjetodatafim())
                        .build();
    }).toList();
    return ThunderDTO3CResposta.builder()
    .projetoDTO(projetosDTO)
    .build();
}

}
