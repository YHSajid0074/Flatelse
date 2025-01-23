package com.agiles.flatelse.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertySearchDto {
    private String location;
    private String price;
    private String propertyType;
    private String propertySize;
    private Boolean parking;
    private Boolean furnished;
    private Boolean petFriendly;
}
