package com.github.alissonydev.forumhub.config;

import com.github.alissonydev.forumhub.domains.topicos.ITopicoRepository;
import com.github.alissonydev.forumhub.domains.topicos.TopicoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class TopicoConfig {

    @Bean
    TopicoService topicoService(ITopicoRepository topicoRepository) {
        return new TopicoService(topicoRepository);
    }
}
