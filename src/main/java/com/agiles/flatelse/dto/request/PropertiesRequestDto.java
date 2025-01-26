package com.agiles.flatelse.dto.request;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record PropertiesRequestDto(

        String location,
        String price,
        Boolean priceType,
        String shortDescription,

        String longDescription,
        String restrictions,

        String propertyType,
        String propertySize,
        Boolean parking,
        Boolean furnished,
        Integer yearBuilt,
        Boolean petFriendly,
        Boolean availabilityStatus,
        String ownerName,
        String ownerContact,
        String dealType,

        Long noOfBedrooms,
        Long noOfBathrooms,
        Long floorLevel,
        Long noOfBalconies,
        String kitchenType,
        String livingAndDiningType,
        String flooringType,
        String airConditioningType,

        Boolean elevator,
        Boolean generator,
        Boolean security,
        Boolean gym,
        Boolean pool,
        String tenantType,

        String schoolDistance,
        String hospitalDistance,
        String mainRoadDistance,

        String gasConnection,
        String waterAvailability,
        Boolean cctv,
        String occupancyRequirements,
        String leaseTerm,
        String facingDirection,
        Boolean roofTopAllowed,
        String renovationStatus,
        String deposit,



        MultipartFile heroImage,
        List<MultipartFile> imageUrls,

        Boolean loved,
        String userName

) {

}

