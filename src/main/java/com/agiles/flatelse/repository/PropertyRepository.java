package com.agiles.flatelse.repository;

import com.agiles.flatelse.dto.response.PropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
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

    // Search by parking availability
    @Query("""
            select p from Properties p where p.parking = :parking
            """)
    List<PropertiesResponseDto> searchByParking(@Param("parking") Boolean parking);

    // Search by furnished status
    @Query("""
            select p from Properties p where p.furnished = :furnished
            """)
    List<PropertiesResponseDto> searchByFurnished(@Param("furnished") Boolean furnished);

    // Search by property type
    @Query("""
            select p from Properties p where p.propertyType = :propertyType
            """)
    List<PropertiesResponseDto> searchByPropertyType(@Param("propertyType") String propertyType);

    // Search by location
    @Query("""
            select p from Properties p where p.location like %:location%
            """)
    List<PropertiesResponseDto> searchByLocation(@Param("location") String location);

 @Query("""
           SELECT p FROM Properties p WHERE p.petFriendly = :petFriendly
           """)
 List<PropertiesResponseDto> findByPetFriendly(Boolean petFriendly);
}
