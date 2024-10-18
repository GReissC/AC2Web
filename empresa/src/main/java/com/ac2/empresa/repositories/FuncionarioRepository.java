package com.ac2.empresa.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ac2.empresa.models.Funcionario;
import com.ac2.empresa.models.Projeto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {


    @Query("""
            Select f From Funcionario f
            Left Join Fetch projetos
            Where f.id =: funcionarioid
            """)
    List<Projeto> query3C(@Param("funcionarioid") Integer funcionarioid);
    
}
