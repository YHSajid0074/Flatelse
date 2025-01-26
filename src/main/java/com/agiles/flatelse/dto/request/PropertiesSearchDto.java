package com.agiles.flatelse.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertiesSearchDto {
    private String location;
    private String price;
    private String propertyType;
    private Long noOfBedrooms;
    private Long noOfBathrooms;
    private Boolean parking;
    private Boolean furnished;
    private Boolean petFriendly;
    private Boolean elevator;
    private Boolean generator;
    private Boolean security;
    private Boolean gym;
    private Boolean pool;
    private String schoolDistance;
    private String hospitalDistance;
    private String mainRoadDistance;
    private String facingDirection;
    private String tenantType;
    private Boolean loved;
    private Long noOfBalconies;
    private String kitchenType;

    private String gasConnection;
    private Boolean cctv;
    private String OccupancyRequirements;
    private Boolean roofTopAllowed;

    private Integer pageNumber;
    private Integer pageSize;
}
