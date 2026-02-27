package com.github.alissonydev.forumhub.domains.topicos;

import com.github.alissonydev.forumhub.api.dtos.DadosCadastroTopico;
import com.github.alissonydev.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;

public interface ITopicoService {
    DadosDetalhamentoTopicoDTO salvarTopico(DadosCadastroTopico dados);
}
