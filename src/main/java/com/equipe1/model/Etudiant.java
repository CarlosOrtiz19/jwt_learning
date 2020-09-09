package com.equipe1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Etudiant {

    @Id
    private Long id;

    private String nom;

    public Etudiant(String nom){
        this.nom = nom;
    }
}
