package com.github.alissonydev.forumhub.domains.topicos;

import com.github.alissonydev.forumhub.api.dtos.DadosAtualizacaoTopico;
import com.github.alissonydev.forumhub.api.dtos.DadosCadastroTopico;
import com.github.alissonydev.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;
import com.github.alissonydev.forumhub.api.dtos.DadosListagemTopico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITopicoService {
    Page<DadosListagemTopico> paginar(Pageable paginacao);
    DadosDetalhamentoTopicoDTO detalhar(Long id);
    DadosDetalhamentoTopicoDTO salvarTopico(DadosCadastroTopico dados);
    DadosDetalhamentoTopicoDTO atualizar( Long id ,  DadosAtualizacaoTopico dados);
    void deletar(Long id);
}
