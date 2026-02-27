package com.github.alissonydev.forumhub.domains.topicos;

import com.github.alissonydev.forumhub.api.dtos.DadosCadastroTopico;
import com.github.alissonydev.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService implements ITopicoService{

    private final ITopicoRepository topicoRepository;

    public TopicoService(ITopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    @Transactional
    public DadosDetalhamentoTopicoDTO salvarTopico(DadosCadastroTopico dados) {
        final Topico topicoCriado = topicoRepository.save(new Topico(dados));
        return new DadosDetalhamentoTopicoDTO(topicoCriado);
    }
}
