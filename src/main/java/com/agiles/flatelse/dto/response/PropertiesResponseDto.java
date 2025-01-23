package com.agiles.flatelse.dto.response;

import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;
import com.agiles.flatelse.auth.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertiesResponseDto {
    private Long id;
    private String location;
    private String price;
    private String shortDescription;
    private String longDescription;
    private String features;
    private String restrictions;
    private String propertyType;
    private String propertySize;
    private Boolean parking;
    private Boolean furnished;
    private Integer yearBuilt;
    private Boolean petFriendly;
    private Boolean availabilityStatus;
    private String ownerName;
    private String ownerContact;
    private String additionalDetails;
    private String heroImage;
    private List<String> imageUrls;
    private CustomUserResponseDTO user;
    private List<String> shortTitle;
}
