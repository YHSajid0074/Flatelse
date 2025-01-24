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
    private String propertySize;
    private String dealType;
    private Boolean petFriendly;
    private Boolean parking;
    private Boolean furnished;
    private Integer pageNumber;
    private Integer pageSize;
}
