package com.github.alissonydev.forumhub.api.dtos;

import com.github.alissonydev.forumhub.domains.topicos.Topico;

public record DadosListagemTopico(

        Long id ,
        String titulo ,
        String mensagem ,
        String dataCriacao
) {
    public DadosListagemTopico(Topico topico) {
        this(
                topico.getId() ,
                topico.getTitulo() ,
                topico.getMensagem() ,
                topico.getDataCriacao().toString()
        );
    }
}
