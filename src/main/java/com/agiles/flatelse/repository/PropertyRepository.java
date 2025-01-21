package com.agiles.flatelse.repository;

import com.agiles.flatelse.dto.response.PropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Properties, Long> {

    @Query("""
              select p FROM Properties p WHERE p.id = :id
            """)
   Optional<PropertiesResponseDto> getPropertiesById(Long id);

    @Query("""
            select p from Properties p
            """)
    List<PropertiesResponseDto> getAllProperties();

//    Page<PropertiesResponseDto>search(
//            @Param("query") String query,
//            Pageable pageable
//    );
}
