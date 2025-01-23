package com.agiles.flatelse.repository;

import com.agiles.flatelse.dto.response.IPropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Properties, Long> {

    @Query("""
              select p FROM Properties p WHERE p.id = :id
            """)
   Optional<IPropertiesResponseDto> getPropertiesById(Long id);

    @Query("""
        SELECT p
        FROM Properties p
        WHERE (COALESCE(:location, '') = '' OR LOWER(p.location) LIKE CONCAT('%', LOWER(:location), '%'))
          AND (:price IS NULL OR p.price < :price)
          AND (COALESCE(:propertyType, '') = '' OR LOWER(p.propertyType) LIKE CONCAT('%', LOWER(:propertyType), '%'))
          AND (COALESCE(:propertySize, '') = '' OR LOWER(p.propertySize) LIKE CONCAT('%', LOWER(:propertySize), '%'))
          AND (:parking IS NULL OR p.parking = :parking)
          AND (:furnished IS NULL OR p.furnished = :furnished)
          AND (:petFriendly IS NULL OR p.petFriendly = :petFriendly)
        """)
    Page<IPropertiesResponseDto> getAllProperties(
            String location,
            String price,
            String propertyType,
            String propertySize,
            Boolean parking,
            Boolean furnished,
            Boolean petFriendly,
            Pageable pageable
    );
//    Page<PropertiesResponseDto>search(
//            @Param("query") String query,
//            Pageable pageable
//    );
}
