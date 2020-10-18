package com.equipe1.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JwtResponse implements Serializable {
    private String jwtToken;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public JwtResponse(String jwtToken, Long id, String username, String email, List<String> roles) {
        this.jwtToken = jwtToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getToken(){
        return this.jwtToken;
    }
}
