package com.agiles.flatelse.auth.service;

import com.agiles.flatelse.auth.dto.request.UserRequestDTO;
import com.agiles.flatelse.auth.dto.request.UserRoleRequestDTO;
import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;
import com.agiles.flatelse.auth.model.User;

public interface UserService {

    public void create( UserRequestDTO requestDto );
    public CustomUserResponseDTO readOne(Long id );
    public User setUserRoles(UserRoleRequestDTO requestDTO );

}