package com.ac2.empresa.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ac2.empresa.models.Funcionario;
import com.ac2.empresa.models.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

    @Query("""
            Select s From Setor s
            Left Join Fetch funcionariosetor
            Where s.id =: setorid
            """)
    List<Setor> query3D(@Param("setorid") Integer setorid);
    
}
