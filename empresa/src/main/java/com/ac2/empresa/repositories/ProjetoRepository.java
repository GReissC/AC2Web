package com.ac2.empresa.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ac2.empresa.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    @Query("""
                Select p From Projeto p
                Left Join Fetch funcionarios
                Where p.id = :projetoid
            """)
    List<Projeto> query3A(@Param("projetoid")Integer projetoid);

    @Query("""
            Select p From Projeto p
        Where projetodatainicio Between :datacomeco AND :datafim
            """)
    List<Projeto> query3B(@Param("datacomeco") LocalDate datacomeco, @Param("datafim") LocalDate datafim);

}
