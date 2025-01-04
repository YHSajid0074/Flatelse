package com.agiles.flatelse.dto.response;


import java.util.List;

public interface PropertiesResponseDto {

    String getLocation();

    String getPrice();

    String getShortDescription();

    String getLongDescription();

    String getFeatures();

    String getRestrictions();

    String getHeroImage();

    List<String> getImageUrls();

    List<String> getShortTitle();

    String getPropertyType();

    String getPropertySize();

    Boolean getParking();

    Boolean getFurnished();

    Integer getYearBuilt();

    Boolean getPetFriendly();

    String getAvailabilityStatus();

    String getOwnerName();

    String getOwnerContact();
}

