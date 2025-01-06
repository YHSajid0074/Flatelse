package com.agiles.flatelse.auth.controller;

import com.agiles.flatelse.auth.dto.request.UserRequestDTO;
import com.agiles.flatelse.auth.dto.request.UserRoleRequestDTO;
import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;
import com.agiles.flatelse.auth.service.UserServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/User" )
public class UserController {

    private UserServiceIMPL userService;

    public UserController( UserServiceIMPL userService ) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity< String > create( UserRequestDTO requestDto ) {
        userService.create(requestDto);
        return ResponseEntity.ok("Successfully created user");
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @GetMapping( "{id}" )
    public ResponseEntity<CustomUserResponseDTO> readOne(@PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( userService.readOne( id ) );
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping( "change-roles" )
    public ResponseEntity<String> setUserRoles(@RequestBody UserRoleRequestDTO requestDTO ) {
        userService.setUserRoles( requestDTO ) ;
        return ResponseEntity.ok("Successfully set user roles");
    }
}