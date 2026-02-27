package com.github.alissonydev.forumhub.domains.topicos;

import com.github.alissonydev.forumhub.api.dtos.DadosCadastroTopico;
import com.github.alissonydev.forumhub.domains.respostas.Resposta;
import com.github.alissonydev.forumhub.domains.topicos.enums.TopicoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 20 , nullable = false)

    private TopicoStatus status;

    @Column(length = 100)
    private String autor;

    @Column(length = 100)
    private String curso;

    @OneToMany(mappedBy = "topico" , fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    private List<Resposta> resposta;

    public Topico(DadosCadastroTopico dados) {
        titulo = dados.titulo();
        mensagem = dados.mensagem();
        autor = dados.nomeAutor();
        curso = dados.nomeCurso();
    }

    @PrePersist
    public void onPrePersist() {
        status = TopicoStatus.NAO_RESPONDIDO;
        dataCriacao = Instant.now();
    }
}
