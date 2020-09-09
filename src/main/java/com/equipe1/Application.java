package com.equipe1;

import com.equipe1.model.Etudiant;
import com.equipe1.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private EtudiantRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Etudiant e1 = new Etudiant("toto");
				repository.save(e1);
				e1 = new Etudiant("tata");
				repository.save(e1);
				e1 = new Etudiant("tutu");
				repository.save(e1);
			}
		};
	}
}
