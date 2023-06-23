package com.senai.devinadoption.service;


import com.senai.devinadoption.model.Usuario;

public interface UsuarioService {


    Usuario cadastrarUsuario(String nome, String email, String senha) throws Exception;

    boolean loginUsuario(String email, String senha);


}


