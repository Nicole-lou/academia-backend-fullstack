package com.projetos.academia.controller;

import com.projetos.academia.model.Plano;
import com.projetos.academia.model.Plano.StatusPlano;
import com.projetos.academia.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final PlanoRepository planoRepository;

    @Autowired
    public HomeController(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        // 1. Busca no banco de dados os planos ATIVOS (StatusPlano.ON)
        // e já os ordena pelo campo 'order' de forma ascendente (Asc).
        List<Plano> planosAtivos = planoRepository.findByStatusOrderByOrdemAsc(StatusPlano.ON);
        //List<Plano> planosAtivos = planoRepository.findByStatus(StatusPlano.ON);

        // 2. Adiciona a lista de planos ordenada ao Model
        model.addAttribute("planos", planosAtivos);

        // 3. Retorna o template home.ftl
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