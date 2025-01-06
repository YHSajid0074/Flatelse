package com.agiles.flatelse.auth.controller;

import com.agiles.flatelse.auth.dto.request.LoginRequestDTO;
import com.agiles.flatelse.auth.dto.response.LoginResponseDTO;
import com.agiles.flatelse.auth.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Log")
public class AuthenticationController implements IAuthenticationController {


    private IAuthenticationService authenticationService;
    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping()
    @Override
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO ) {
        return ResponseEntity.ok( authenticationService.login( requestDTO ) );
    }
}
