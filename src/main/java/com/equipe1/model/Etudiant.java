package com.equipe1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Etudiant extends UserApp{

    private String programme;

    private String adresse;

    private String statutStage;

    //private Stage stage;

    public Etudiant(String nom){
        nom = nom;
    }
}
