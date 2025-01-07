package com.agiles.flatelse.auth.service;

import com.agiles.flatelse.auth.dto.request.UserRequestDTO;
import com.agiles.flatelse.auth.dto.request.UserRoleRequestDTO;
import com.agiles.flatelse.auth.dto.request.UserUpdateRequestDto;
import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;
import com.agiles.flatelse.auth.model.User;
import org.hibernate.sql.Update;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    public void create(UserRequestDTO requestDto, MultipartFile file) throws IOException;
    public CustomUserResponseDTO readOne(Long id );
    public User setUserRoles(UserRoleRequestDTO requestDTO );
    public void updateUser(Long id, UserUpdateRequestDto userRequestDTO, MultipartFile file) throws IOException;
    public CustomUserResponseDTO searchByUsername(String username);
}