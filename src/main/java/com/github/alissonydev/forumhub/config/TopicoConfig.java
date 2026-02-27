package com.github.alissonydev.forumhub.config;

import com.github.alissonydev.forumhub.domains.topicos.ITopicoRepository;
import com.github.alissonydev.forumhub.domains.topicos.TopicoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicoConfig {

    @Bean
    TopicoService topicoService(ITopicoRepository topicoRepository) {
        return new TopicoService(topicoRepository);
    }
}
