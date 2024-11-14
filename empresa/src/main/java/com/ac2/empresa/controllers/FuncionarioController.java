package com.ac2.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.empresa.dtos.FuncionarioDTO;
import com.ac2.empresa.dtos.dtoRequest.ThunderDTO3C;
import com.ac2.empresa.dtos.dtoRequest.ThunderDTO3CResposta;
import com.ac2.empresa.models.Funcionario;
import com.ac2.empresa.services.FuncionarioServiceImp;



@RestController
@RequestMapping("api/empresa/funcionariocontroller")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImp funcionarioServiceImp;

    @PostMapping
    public void saveFuncionario(@RequestBody FuncionarioDTO dto) {
        funcionarioServiceImp.salvar(dto);
    }

    @GetMapping()
    public void obterTodos(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioServiceImp.obterTodos();
        
    }

    @PutMapping("path/{id}")
    public void updateFuncionario(@RequestBody Integer funcionarioid, FuncionarioDTO funcionarioDTO) {
        funcionarioServiceImp.editar(funcionarioid, funcionarioDTO);
    }

    @DeleteMapping()
    public void deleteFuncionario(@RequestBody Integer funcionarioid) {
        funcionarioServiceImp.deletar(funcionarioid);
    }

    @GetMapping("/projetosatuais")
    public ThunderDTO3CResposta projetosEnvolvido(@RequestBody ThunderDTO3C dto) {
        return funcionarioServiceImp.projetosEnvolvidos(dto.funcionarioid());
    }

}
