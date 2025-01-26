package com.agiles.flatelse.dto.response;

import com.agiles.flatelse.auth.dto.response.CustomUserResponseDTO;

import java.util.List;

public interface IPropertiesResponseDto {

    Long getId();

    String getLocation();
    String getPrice();
    Boolean getPriceType();
    String getShortDescription();
    String getLongDescription();
    String getRestrictions();

    String getPropertyType();
    String getPropertySize();
    Boolean getParking();
    Boolean getFurnished();
    Integer getYearBuilt();
    Boolean getPetFriendly();
    Boolean getAvailabilityStatus();
    String getOwnerName();
    String getOwnerContact();
    String getDealType();

    Long getNoOfBedrooms();
    Long getNoOfBathrooms();
    Long getFloorLevel();
    Long getNoOfBalconies();
    String getKitchenType();
    String getLivingAndDiningType();
    String getFlooringType();
    String getAirConditioningType();

    Boolean getElevator();
    Boolean getGenerator();
    Boolean getSecurity();
    Boolean getGym();
    Boolean getPool();
    String getTenantType();

    String getSchoolDistance();
    String getHospitalDistance();
    String getMainRoadDistance();

    String getGasConnection();
    String getWaterAvailability();
    Boolean getCctv();
    String getOccupancyRequirements();
    String getLeaseTerm();
    String getFacingDirection();
    Boolean getRoofTopAllowed();
    String getRenovationStatus();
    String getDeposit();

    String getHeroImage(); // Assuming this is stored as a URL or path
    List<String> getImageUrls(); // Assuming URLs or paths

    Boolean getLoved();
    CustomUserResponseDTO getUser();

}

