package com.senai.devinadoption.service;

import com.senai.devinadoption.model.Usuario;
import com.senai.devinadoption.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario cadastrarUsuario(String nome, String email, String senha) throws Exception {
        Usuario existingUsuario = usuarioRepository.findByEmail(email);
        if (existingUsuario != null) {
            throw new Exception("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean loginUsuario(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            return false;
        }

        return usuario.getSenha().equals(senha);
    }
}









