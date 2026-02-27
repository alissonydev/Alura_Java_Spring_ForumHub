package com.github.alissonydev.forumhub.api.dtos;

import com.github.alissonydev.forumhub.domains.respostas.Resposta;

public record DadosRespostaDTO(
        Long id ,
        String mensagem ,
        String autor ,
        String solucao
) {
    public DadosRespostaDTO(Resposta resposta) {
        this(
                resposta.getId() ,
                resposta.getMensagem() ,
                resposta.getAutor() ,
                resposta.getSolucao()
        );
    }
}
