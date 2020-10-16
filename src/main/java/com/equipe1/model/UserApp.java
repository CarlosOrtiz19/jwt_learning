package com.equipe1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String nom;
    protected String prenom;

    @Column(unique=true)
    protected String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String password;

    protected String matricule;

    protected String telephone;
}
