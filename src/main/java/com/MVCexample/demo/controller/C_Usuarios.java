package com.MVCexample.demo.controller;

import com.MVCexample.demo.service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Usuarios {
    @GetMapping("/listar")
    public String getListaUsuarios(Model model){
        model.addAttribute("usuarios", S_Usuario.listarUsuarios());
        return "usuario/pv_listaUsuario";
    }

    @GetMapping("/cadastro")
    public String getCadastroUsuario(){
        return "usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("usuario") String usuario,
                               @RequestParam("senha") String senha,
                               @RequestParam("confSenha") String confSenha,
                               Model model){
        if(S_Usuario.cadastrarUsuario(usuario,senha,confSenha) != null){
            model.addAttribute("erro","Cadastro efetuado com sucesso, faça seu login!");
            return "index";
        }else{
            return "usuario/cadastro";
        }
    }
}
