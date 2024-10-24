package com.ac2.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.empresa.dtos.SetorDTO;
import com.ac2.empresa.services.SetorServiceImp;

@RestController
@RequestMapping("/empresa/Setor")
public class SetorController {
    
    @Autowired
    private SetorServiceImp setorServiceImp;

    @PostMapping
    public void saveFuncionario(@RequestBody SetorDTO dto) {
        setorServiceImp.salvar(dto);
    }

    @PostMapping
    public void obterTodos(@RequestBody SetorDTO setorDTO) {
        setorServiceImp.obterTodos();
        
    }

    @PostMapping
    public void updateFuncionario(@RequestBody Integer setorid, SetorDTO setorDTO) {
        setorServiceImp.editar(setorid, setorDTO);
    }

    @PostMapping
    public void deleteFuncionario(@RequestBody Integer setorid) {
        setorServiceImp.deletar(setorid);
    }

}
