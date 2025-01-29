package com.agiles.flatelse.repository;

import com.agiles.flatelse.dto.response.IPropertiesResponseDto;
import com.agiles.flatelse.dto.response.PropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Properties, Long> {

    @Query("""
    SELECT p 
    FROM Properties p 
    WHERE p.user.id = :userId
""")
    List<IPropertiesResponseDto> getPropertiesByUserId(@Param("userId") Long userId);

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
              AND (COALESCE(:dealType, '') = '' OR LOWER(p.dealType) LIKE CONCAT('%', LOWER(:dealType), '%'))
            """)
    Page<IPropertiesResponseDto> search(
            String location,
            String price,
            String propertyType,
            String propertySize,
            Boolean parking,
            Boolean furnished,
            Boolean petFriendly,
            String dealType,
            Pageable pageable
    );
//    Page<PropertiesResponseDto>search(
//            @Param("query") String query,
//            Pageable pageable
//    );


    @Query("""
    SELECT p FROM Properties p
    WHERE (:dealType IS NULL OR p.dealType = :dealType)
""")
    List<IPropertiesResponseDto> getAllProperties(String dealType);


    @Query("""
        SELECT p
        FROM Properties p
        WHERE (COALESCE(:location, '') = '' OR LOWER(p.location) LIKE CONCAT('%', LOWER(:location), '%'))
          AND (:price IS NULL OR p.price <= :price)
          AND (COALESCE(:propertyType, '') = '' OR LOWER(p.propertyType) LIKE CONCAT('%', LOWER(:propertyType), '%'))
          AND (:parking IS NULL OR p.parking = :parking)
          AND (:furnished IS NULL OR p.furnished = :furnished)
          AND (:petFriendly IS NULL OR p.petFriendly = :petFriendly)
          AND (:noOfBedrooms IS NULL OR p.noOfBedrooms = :noOfBedrooms)
          AND (:noOfBathrooms IS NULL OR p.noOfBathrooms = :noOfBathrooms)
          AND (:elevator IS NULL OR p.elevator = :elevator)
          AND (:generator IS NULL OR p.generator = :generator)
          AND (:security IS NULL OR p.security = :security)
          AND (:gym IS NULL OR p.gym = :gym)
          AND (:pool IS NULL OR p.pool = :pool)
          AND (COALESCE(:schoolDistance, '') = '' OR LOWER(p.schoolDistance) LIKE CONCAT('%', LOWER(:schoolDistance), '%'))
          AND (COALESCE(:hospitalDistance, '') = '' OR LOWER(p.hospitalDistance) LIKE CONCAT('%', LOWER(:hospitalDistance), '%'))
          AND (COALESCE(:mainRoadDistance, '') = '' OR LOWER(p.mainRoadDistance) LIKE CONCAT('%', LOWER(:mainRoadDistance), '%'))
          AND (COALESCE(:facingDirection, '') = '' OR LOWER(p.facingDirection) LIKE CONCAT('%', LOWER(:facingDirection), '%'))
          AND (COALESCE(:tenantType, '') = '' OR LOWER(p.tenantType) LIKE CONCAT('%', LOWER(:tenantType), '%'))
          AND (:loved IS NULL OR p.loved = :loved)
          AND (:noOfBalconies IS NULL OR p.noOfBalconies >= :noOfBalconies)
          AND (COALESCE(:kitchenType, '') = '' OR LOWER(p.kitchenType) LIKE CONCAT('%', LOWER(:kitchenType), '%'))
          AND (COALESCE(:gasConnection, '') = '' OR LOWER(p.gasConnection) LIKE CONCAT('%', LOWER(:gasConnection), '%'))
          AND (:cctv IS NULL OR p.cctv = :cctv)
          AND (COALESCE(:OccupancyRequirements, '') = '' OR LOWER(p.OccupancyRequirements) LIKE CONCAT('%', LOWER(:OccupancyRequirements), '%'))
          AND (:roofTopAllowed IS NULL OR p.roofTopAllowed = :roofTopAllowed)
        """)
    List<IPropertiesResponseDto> search1(
            String location,
            String price,
            String propertyType,
            Long noOfBedrooms,
            Long noOfBathrooms,
            Boolean parking,
            Boolean furnished,
            Boolean petFriendly,
            Boolean elevator,
            Boolean generator,
            Boolean security,
            Boolean gym,
            Boolean pool,
            String schoolDistance,
            String hospitalDistance,
            String mainRoadDistance,
            String facingDirection,
            String tenantType,
            Boolean loved,
            Long noOfBalconies,
            String kitchenType,
            String gasConnection,
            Boolean cctv,
            String OccupancyRequirements,
            Boolean roofTopAllowed
    );

}
