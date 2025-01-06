package com.agiles.flatelse.auth.service;

import com.agiles.flatelse.auth.dto.request.UserRequestDTO;
import com.agiles.flatelse.auth.dto.request.UserRoleRequestDTO;
import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;
import com.agiles.flatelse.auth.model.Role;
import com.agiles.flatelse.auth.model.User;
import com.agiles.flatelse.auth.repository.RoleRepo;
import com.agiles.flatelse.auth.repository.UserRepo;
import com.agiles.flatelse.notification.SSEService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Set;

@Service

public class UserServiceIMPL implements UserService {

    private  UserRepo userRepository;
    private  PasswordEncoder passwordEncoder;
    private  RoleRepo roleRepository;
    private  SSEService<User> userSSEService;

   public UserServiceIMPL(UserRepo userRepo,PasswordEncoder passwordEncoder,RoleRepo roleRepository,SSEService<User> userSSEService) {
       this.userRepository = userRepo;
       this.passwordEncoder = passwordEncoder;
       this.roleRepository = roleRepository;
       this.userSSEService = userSSEService;
   }


    public void create( UserRequestDTO requestDto ) {
        User user = new User();
        user.setUsername( requestDto.username() );
        user.setEmail( requestDto.email() );
        user.setPassword( passwordEncoder.encode(requestDto.password() ));
        userRepository.save( user );
        userSSEService.emit( user );

    }


    public CustomUserResponseDTO readOne(Long id ) {
        CustomUserResponseDTO singleUserById = userRepository.findUserByUserId(id);
        if ( Objects.isNull( singleUserById ) ) {
            throw new RuntimeException( "User with id " + id + " not found." );
        }
        return singleUserById;
    }


    public User setUserRoles( UserRoleRequestDTO requestDTO ) {

        User foundUser = userRepository.findById( requestDTO.userId() ).get();

        if ( Objects.isNull( foundUser ) ) {
            throw new RuntimeException( "User with id " + requestDTO.userId() + " not found." );
        }

        Set<Role> foundRoles = roleRepository.findAllByIdIn( requestDTO.roleIds() );
        foundUser.getRoles().addAll( foundRoles );

        return  userRepository.save( foundUser );

    }

}
