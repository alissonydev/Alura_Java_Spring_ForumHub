package com.github.alissonydev.forumhub.domains.topicos;

import com.github.alissonydev.forumhub.api.dtos.DadosCadastroTopico;
import com.github.alissonydev.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;
import com.github.alissonydev.forumhub.domains.topicos.exceptions.MensagemException;
import com.github.alissonydev.forumhub.domains.topicos.exceptions.TituloException;
import jakarta.validation.Valid;
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
    public DadosDetalhamentoTopicoDTO salvarTopico(@Valid DadosCadastroTopico dados) {

        checarSeTituloExiste(dados.titulo());
        checarSeMensagemExiste(dados.mensagem());

        final Topico topicoCriado = topicoRepository.save(new Topico(dados));
        return new DadosDetalhamentoTopicoDTO(topicoCriado);
    }

    private void checarSeTituloExiste(String titulo) {
        if (titulo != null && topicoRepository.existsByTitulo(titulo)) {
            throw new TituloException("Título já existe");
        }
    }

    private void checarSeMensagemExiste(String mensagem) {
        if (mensagem != null && topicoRepository.existsByMensagem(mensagem)) {
            throw new MensagemException("Mensagem já existe");
        }
    }

}
