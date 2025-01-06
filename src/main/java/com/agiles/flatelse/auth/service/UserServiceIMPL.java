package com.agiles.flatelse.auth.service;

import com.agiles.flatelse.auth.dto.request.UserRequestDTO;
import com.agiles.flatelse.auth.dto.request.UserRoleRequestDTO;
import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;
import com.agiles.flatelse.auth.model.Role;
import com.agiles.flatelse.auth.model.User;
import com.agiles.flatelse.auth.repository.RoleRepo;
import com.agiles.flatelse.auth.repository.UserRepo;
import com.agiles.flatelse.notification.SSEService;
import com.agiles.flatelse.service.CloudneryImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Service

public class UserServiceIMPL implements UserService {

    private  UserRepo userRepository;
    private  PasswordEncoder passwordEncoder;
    private  RoleRepo roleRepository;
    private  SSEService<User> userSSEService;

    @Autowired
    private CloudneryImageService cloudneryImageService;

   public UserServiceIMPL(UserRepo userRepo,PasswordEncoder passwordEncoder,RoleRepo roleRepository,SSEService<User> userSSEService) {
       this.userRepository = userRepo;
       this.passwordEncoder = passwordEncoder;
       this.roleRepository = roleRepository;
       this.userSSEService = userSSEService;
   }


   public User ConvertToEntity(User user,UserRequestDTO userRequestDTO,MultipartFile profilepic) throws IOException {
       Map<String, Object> heroUploadResult = cloudneryImageService.upload(profilepic);
       String profileImageUrl = (String) heroUploadResult.get("secure_url");
       user.setUsername( userRequestDTO.username() );
       user.setEmail( userRequestDTO.email() );
       user.setPassword( passwordEncoder.encode(userRequestDTO.password() ));
       user.setBio(userRequestDTO.bio() );
       user.setAddress( userRequestDTO.address() );
       user.setPhone(userRequestDTO.phone() );
       user.setSold(userRequestDTO.sold());
       user.setProfession(userRequestDTO.profession());
       user.setProfilpic(profileImageUrl);
       user.setPropertyAdded(userRequestDTO.propertyAdded());

       return user;
   }




    public void create(UserRequestDTO requestDto, MultipartFile heroImageFile) throws IOException {

       User user = ConvertToEntity(new User(), requestDto, heroImageFile);

       userRepository.save(user);

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


    @Override
    public void updateUser(Long id,UserRequestDTO userRequestDTO,MultipartFile heroImageFile) throws IOException {

       User user=userRepository.findById( id ).get();

       User updateUser = ConvertToEntity(user, userRequestDTO, heroImageFile);

       userRepository.save( updateUser );

    }



}
