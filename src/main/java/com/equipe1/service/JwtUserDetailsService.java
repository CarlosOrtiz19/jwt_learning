package com.equipe1.service;

import com.equipe1.model.ERole;
import com.equipe1.model.Role;
import com.equipe1.model.UserApp;
import com.equipe1.repository.RoleRepository;
import com.equipe1.repository.UserRepository;
import com.equipe1.security.service.MessageResponse;
import com.equipe1.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserApp user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return UserDetailsImpl.build(user);

        //return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
        //        new ArrayList<>());
    }

    public UserApp save(UserApp userApp) {
        UserApp newUser = new UserApp();
        newUser.setNom(userApp.getNom());
        newUser.setMatricule(userApp.getMatricule());
        newUser.setTelephone(userApp.getTelephone());
        newUser.setPrenom(userApp.getPrenom());
        newUser.setEmail(userApp.getEmail());
        newUser.setDiscriminant(userApp.getDiscriminant());
        newUser.setUsername(userApp.getUsername());
        newUser.setRoles(setRoles(userApp));
        newUser.setPassword(bcryptEncoder.encode(userApp.getPassword()));
        return userRepository.save(newUser);
    }

    public boolean isValidEmail(UserApp user){
        return userRepository.existsByEmail(user.getEmail());
    }

    private Set<Role> setRoles(UserApp user){
        Set<Role> roles = new HashSet<>();
            switch (user.getDiscriminant()) {
                case "manager":
                    Role managerRole = roleRepository.findByRole(ERole.ROLE_MANAGER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(managerRole);

                    break;
                case "student":
                    Role studentRole = roleRepository.findByRole(ERole.ROLE_STUDENT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(studentRole);

                    break;
                case "company":
                    Role companyRole = roleRepository.findByRole(ERole.ROLE_STUDENT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(companyRole);
                    break;
                default:
                    Role userRole = roleRepository.findByRole(ERole.ROLE_UNDEFINED)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }

        System.out.println(roles.size() + " .size desde  roles User");
        return roles;

    }
}
