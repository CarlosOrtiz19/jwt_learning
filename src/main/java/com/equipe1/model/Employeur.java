package com.equipe1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Employeur extends UserApp{

    private String adresse;
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "employeur")
    //private Set<Stage> stages = new HashSet<Stage>();

    public Employeur(String nom, String telephone, String adresse){
        nom = nom;
        telephone = telephone;
        this.adresse = adresse;
    }

}
