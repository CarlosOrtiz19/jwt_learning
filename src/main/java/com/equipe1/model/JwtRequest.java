package com.equipe1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JwtRequest implements Serializable {
    private String email;
    private String password;

    public JwtRequest(String username, String password) {
        this.setEmail(username);
        this.setPassword(password);
    }

}
