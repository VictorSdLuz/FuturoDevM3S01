package com.senai.devinadoption.controller;

import com.senai.devinadoption.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        try {
            usuarioService.cadastrarUsuario(nome, email, senha);
            return ResponseEntity.ok("Usuário cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestParam String email, @RequestParam String senha) {
        boolean logado = usuarioService.loginUsuario(email, senha);
        if (logado) {
            return ResponseEntity.ok("Login realizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tenta novamente!");
        }
    }
}
