package com.equipe1.controller;

import com.equipe1.service.EtudiantService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class HelloWorldController {

    private EtudiantService service;

    public HelloWorldController(EtudiantService service){
        this.service = service;
    }

    @GetMapping("hello")
    public String HelloWorld(@RequestParam("idEtudiant") Long idEtudiant){
        return service.findEtudiantById(idEtudiant);
    }
}
