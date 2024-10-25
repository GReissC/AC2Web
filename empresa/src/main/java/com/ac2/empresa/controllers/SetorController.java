package com.ac2.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac2.empresa.dtos.SetorDTO;
import com.ac2.empresa.models.Setor;
import com.ac2.empresa.repositories.SetorRepository;
import com.ac2.empresa.services.SetorServiceImp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/empresa/Setor")
public class SetorController {

    @Autowired
    private SetorServiceImp setorServiceImp;

    @PostMapping
    public void saveSetor(@RequestBody SetorDTO dto) {
        setorServiceImp.salvar(dto);
    }

    @GetMapping()
    public void obterTodos(@RequestBody SetorDTO setorDTO) {
        setorServiceImp.obterTodos();

    }

    @PutMapping("/{id}")
    public void updateSetor(@RequestBody Integer setorid, SetorDTO setorDTO) {
        setorServiceImp.editar(setorid, setorDTO);
    }

    @DeleteMapping
    public void deleteSetor(@RequestBody Integer setorid) {
        setorServiceImp.deletar(setorid);
    }

    @GetMapping("/setorF")
    public List<Setor> buscarFuncionariosSetor(@RequestParam Integer setorid) {
        List<Setor> setorFuncionario = setorServiceImp.buscarFuncionarios(setorid);
        return setorFuncionario;
    }
    

}
