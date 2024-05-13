package com.MVCexample.demo.service;

import com.MVCexample.demo.Model.M_Usuario;
import com.MVCexample.demo.repository.R_Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public static List<M_Usuario> listarUsuarios() {
        return r_usuario.listarUsuarios();
    }

    public static M_Usuario cadastrarUsuario(String usuario, String senha, String confSenha) {
        boolean podeSalvar = true;

        if (usuario.trim().equals("") || usuario == null) {
            podeSalvar = false;
        } else if (senha.trim().equals("") || senha == null) {
            podeSalvar = false;
        } else if (!senha.equals(confSenha)) {
            podeSalvar = false;
        }

        if (podeSalvar) {
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setUsuario(usuario.trim());
            m_usuario.setSenha(senha.trim());
            try {
                m_usuario = r_usuario.save(m_usuario);
                return m_usuario;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
