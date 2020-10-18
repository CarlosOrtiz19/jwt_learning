package com.equipe1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends UserApp{

    private String programme;

    private String adresse;

    private String statutStage;

    //private Stage stage;

    public Etudiant(String nom){
        nom = nom;
    }
}
