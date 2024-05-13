package com.MVCexample.demo.controller;

import com.MVCexample.demo.service.S_Login;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Login {
    @GetMapping("/")
    public String showLogin(){
        return "index";
    }

    @PostMapping("/")
    public String validaLogin(@RequestParam("usuario") String usuario,
                              @RequestParam("senha") String senha,
                              HttpSession session,
                              Model model){
        session.setAttribute("usuario", S_Login.validaLogin(usuario,senha));
        if(session.getAttribute("usuario") != null){

            return "home/home";
        }
        model.addAttribute("erro","Usuário ou senha inválido!");
        model.addAttribute("usuario",usuario);
        return "index";
    }
}
