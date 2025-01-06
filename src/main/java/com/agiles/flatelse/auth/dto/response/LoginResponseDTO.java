package com.agiles.flatelse.auth.dto.response;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Set;

public record LoginResponseDTO(
        String token,

        String username,

        String email,

        Set< String > roles
) implements Serializable {
}
