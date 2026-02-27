package com.github.alissonydev.forumhub.api.controllers.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(

        LocalDateTime timestamp ,
        int status ,
        String error
) {
}
