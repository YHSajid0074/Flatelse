package com.agiles.flatelse.dto.request;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record PropertiesRequestDto(
        String location,
        String price,
        String shortDescription,
        String longDescription,
        String features,
        String restrictions,
        MultipartFile heroImage,
        List<MultipartFile> imageUrls,
        List<String> shortTitle,
        String propertyType,
        String propertySize,
        Boolean parking,
        Boolean furnished,
        Integer yearBuilt,
        Boolean petFriendly,
        String availabilityStatus,
        String ownerName,
        String ownerContact
) {

}

