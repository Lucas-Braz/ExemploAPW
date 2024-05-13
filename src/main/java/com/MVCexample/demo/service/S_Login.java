package com.MVCexample.demo.service;

import com.MVCexample.demo.Model.M_Usuario;
import com.MVCexample.demo.repository.R_Usuario;
import org.springframework.stereotype.Service;

@Service
public class S_Login {
    private static R_Usuario r_usuario;

    public S_Login(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public static M_Usuario validaLogin(String usuario, String senha){
        return r_usuario.buscaUsuarioLogin(usuario,senha);
    }
}
