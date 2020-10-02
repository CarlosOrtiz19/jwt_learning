package com.equipe1.repository;

import com.equipe1.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserApp, Long> {
    UserApp findByEmail(String email);
    UserApp findByUsername(String username);
}
