package com.senai.devinadoption.controller;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.model.Armazem;
import com.senai.devinadoption.service.ArmazemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/armazem")
public class ArmazemController {
    private final ArmazemService armazemService;

    public ArmazemController(ArmazemService armazemService) {
        this.armazemService = armazemService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarArmazem(
            @RequestParam String nome,
            @RequestParam Animal tipoAnimal) {
        try {
            Armazem armazem = armazemService.cadastrarArmazem(nome, tipoAnimal);
            return ResponseEntity.ok("Armazém cadastrado com sucesso. ID do armazém: " + armazem.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar armazém: " + e.getMessage());
        }
    }
}

