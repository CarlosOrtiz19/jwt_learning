package com.equipe1.service;

import com.equipe1.model.Etudiant;
import com.equipe1.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

@Service
public class EtudiantService {

    private EtudiantRepository repository;

    public EtudiantService(EtudiantRepository repository){
        this.repository = repository;
    }

    public String findEtudiantById(Long idEtudiant){
        return repository.findById(idEtudiant).orElse(new Etudiant()).getNom();
    }
}
