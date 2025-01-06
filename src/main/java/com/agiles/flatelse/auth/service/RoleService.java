package com.agiles.flatelse.auth.service;

import com.agiles.flatelse.auth.dto.response.CustomRoleResponseDTO;

public interface RoleService {

    public CustomRoleResponseDTO readOne(Long id );
    public String delete( Long id );

}
