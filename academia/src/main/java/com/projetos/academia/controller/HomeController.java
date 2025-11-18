package com.projetos.academia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        return "blog";
    }

    @GetMapping("/contato")
    public String contato(Model model) {
        return "contato";
    }

    @GetMapping("/aulas")
    public String aulas(Model model) {
        return "aulas";
    }

    @GetMapping("/privacidade")
    public String privacidade(Model model) {
        return "privacidade";
    }


}
