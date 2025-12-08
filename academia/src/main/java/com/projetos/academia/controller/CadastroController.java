package com.projetos.academia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/cadastro") // AQUI DEFINIMOS A ROTA BASE
public class CadastroController {

    /**
     * Mapeia para a URL: /cadastro
     * Exibe o formulário de cadastro, injetando o plano escolhido na URL.
     */
    @GetMapping
    public String exibirFormularioCadastro(@RequestParam(value = "plano", required = false) Optional<String> planoEscolhido, Model model) {

        String nomePlano = planoEscolhido.orElse("Plano Não Selecionado");
        model.addAttribute("planoSelecionado", nomePlano);

        // Futuramente, aqui você também prepararia DTOs ou listas para o formulário

        return "cadastro"; // Retorna o template cadastro.html
    }

    /* * Futuramente, o método POST para salvar os dados virá aqui:
     * @PostMapping
     * public String salvarCadastro(CadastroDTO dados) { ... }
     */
}