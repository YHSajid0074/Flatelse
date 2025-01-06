package com.agiles.flatelse.auth.service;


import com.agiles.flatelse.auth.dto.request.LoginRequestDTO;
import com.agiles.flatelse.auth.dto.response.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}
