package com.agiles.flatelse.auth.repository;

import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;
import com.agiles.flatelse.auth.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long > {

    @EntityGraph( attributePaths = { "roles" } )
    User findByUsernameOrEmail(String username, String email );

    boolean existsByUsername( String username );

    boolean existsByEmail( String email );

    @EntityGraph( attributePaths = { "roles" } )
    @Query( """
                SELECT
                    user
                FROM
                    User user
                WHERE
                    user.id = :id
            """ )
    CustomUserResponseDTO findUserByUserId(@Param( "id" ) Long id );
}
