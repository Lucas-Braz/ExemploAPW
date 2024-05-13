package com.MVCexample.demo.controller;

import com.MVCexample.demo.service.S_Aluno;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Aluno {
    @GetMapping("/cadAluno")
    public String getCadAluno(HttpSession session){
        if(session.getAttribute("usuario") != null){
            return "aluno/cadAluno";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/cadAluno")
    public String postCadAluno(@RequestParam("nome") String nome,
                               @RequestParam("dataNasc") String dataNasc,
                               @RequestParam("email") String email,
                               Model model){
        if(S_Aluno.cadastrarAluno(nome,email,dataNasc) != null){
            model.addAttribute("mensagem","Aluno Cadastrado Com Sucesso");
            model.addAttribute("bg","success");
        }else{
            model.addAttribute("mensagem","Erro ao cadastrar o aluno");
            model.addAttribute("bg","danger");
            model.addAttribute("nome",nome);
            model.addAttribute("datanascimento",dataNasc);
            model.addAttribute("email",email);
        }

        return "aluno/cadAluno";
    }
}
