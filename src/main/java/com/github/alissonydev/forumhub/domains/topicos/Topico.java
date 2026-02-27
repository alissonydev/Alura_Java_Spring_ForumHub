package com.github.alissonydev.forumhub.domains.topicos;

import com.github.alissonydev.forumhub.api.dtos.DadosAtualizacaoTopico;
import com.github.alissonydev.forumhub.api.dtos.DadosCadastroTopico;
import com.github.alissonydev.forumhub.domains.respostas.Resposta;
import com.github.alissonydev.forumhub.domains.topicos.enums.TopicoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_topicos")
public class Topico {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false , unique = true)
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false , unique = true)
    private String mensagem;

    @Column(name = "data_criacao", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 20 , nullable = false)
    private TopicoStatus status;

    @Column(length = 100 , nullable = false)
    private String autor;

    @Column(length = 100 , nullable = false)
    private String curso;

    @OneToMany(mappedBy = "topico" , fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    private List<Resposta> resposta = new ArrayList<>();

    public Topico(DadosCadastroTopico dados) {
        titulo = dados.titulo();
        mensagem = dados.mensagem();
        autor = dados.nomeAutor();
        curso = dados.nomeCurso();
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) titulo = dados.titulo();
        if (dados.mensagem() != null) mensagem = dados.mensagem();
        if (dados.status() != null) status = dados.status();
        if (dados.nomeAutor() != null) autor = dados.nomeAutor();
        if (dados.nomeCurso() != null) curso = dados.nomeCurso();
    }

    @PrePersist
    public void onPrePersist() {
        status = TopicoStatus.NAO_RESPONDIDO;
        dataCriacao = Instant.now();
    }
}
