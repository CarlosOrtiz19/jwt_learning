package com.equipe1;


import com.equipe1.model.ERole;
import com.equipe1.model.Etudiant;
import com.equipe1.model.Role;
import com.equipe1.repository.EtudiantRepository;


import com.equipe1.repository.RoleRepository;
import com.equipe1.service.InsertDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private InsertDataService service;


	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				//service.insertEtudiant();

				//service.insertEmployeur();

				Role role = new Role(ERole.ROLE_STUDENT);
				roleRepository.save(role);
				role = new Role(ERole.ROLE_COMPANY);
				roleRepository.save(role);
				role = new Role(ERole.ROLE_MANAGER);
				roleRepository.save(role);
				role = new Role(ERole.ROLE_UNDEFINED);
				roleRepository.save(role);

			}
		};
	}
}
