package com.ac2.empresa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ac2.empresa.models.Funcionario;
import com.ac2.empresa.models.Projeto;
import com.ac2.empresa.models.Setor;
import com.ac2.empresa.repositories.FuncionarioRepository;
import com.ac2.empresa.repositories.ProjetoRepository;
import com.ac2.empresa.repositories.SetorRepository;

@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}


	@Bean
	public CommandLineRunner init
			(
				@Autowired FuncionarioRepository funcionarioRepository,
				@Autowired ProjetoRepository projetoRepository,
				@Autowired SetorRepository setorRepository
			) {
			return args -> {
				var f1 = new Funcionario("A");
				var f2 = new Funcionario("B");

				var p1 = new Projeto("Projeto 01", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 6, 5));
				var p2 = new Projeto("Projeto 02", LocalDate.of(2024, 3, 2), LocalDate.of(2024, 7, 6));

				var s1 = new Setor(1, "TI");
				var s2 = new Setor(2, "Artes");

				setorRepository.saveAll(List.of(s1, s2));

				f1.setSetor(s1);
				f2.setSetor(s1);

				p1.setFuncionarios(List.of(f1));
				p2.setFuncionarios(List.of(f2));

				funcionarioRepository.saveAll(List.of(f1, f2));
				projetoRepository.saveAll(List.of(p1, p2));
		};
	};
}


