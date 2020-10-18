package com.equipe1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public Role() {
    }

    public Role(ERole role) {
        this.role = role;
    }

    //@ManyToMany(mappedBy = "roles")
    //Set<UserApp> users;

}
