package com.ac2.empresa.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ac2.empresa.dtos.SetorDTO;
import com.ac2.empresa.models.Setor;
import com.ac2.empresa.repositories.SetorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorServiceImp implements SetorService{


    @Autowired
    private SetorRepository setorRepository;

    @Override
    public void salvar(SetorDTO setorDTO) {
        Setor setorcriado = new Setor(setorDTO.getSetoriddto(), setorDTO.getSetornomedto(), null);
        setorRepository.save(setorcriado);

    }

@Override
public void obterTodos() {
    setorRepository.findAll();
}

@Override
public void editar(Integer setorid, SetorDTO setorDTO) {
    Setor setoreditado = setorRepository.getReferenceById(setorid);
    setoreditado.setSetornome(setorDTO.getSetornomedto());
    setorRepository.save(setoreditado);
    
}

@Override
public void deletar(Integer setorid) {
    Setor setordeletado = setorRepository.getReferenceById(setorid);
    setorRepository.delete(setordeletado);
}

@Override
public void buscarPorId(Integer setorid) {
    setorRepository.findById(setorid);
}
}
