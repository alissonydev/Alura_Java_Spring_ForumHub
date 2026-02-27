package com.github.alissonydev.forumhub.api.controllers;

import com.github.alissonydev.forumhub.api.dtos.DadosCadastroTopico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController


@RequestMapping("topicos")
public class TopicoController {

    @GetMapping
    public String ok() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity<DadosCadastroTopico> cadastrar(@RequestBody DadosCadastroTopico dados) {
        return ResponseEntity.ok(dados);
    }

}
