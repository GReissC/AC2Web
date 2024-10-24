package com.ac2.empresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.models.Funcionario;
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

}
