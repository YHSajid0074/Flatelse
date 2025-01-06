package com.agiles.flatelse.auth.controller;

import com.agiles.flatelse.auth.dto.request.LoginRequestDTO;
import com.agiles.flatelse.auth.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {

    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );

}
