package com.agiles.flatelse.model;

import com.agiles.flatelse.auth.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String price;
//    negotiatable or fixed
    private Boolean priceType;
    @Column(length = 500)
    private String shortDescription;
    @Column(length = 5000)
    private String longDescription;
    private String restrictions;
//    commertial,recidential
    private String propertyType;
    private String propertySize;
    private Boolean parking;
    private Boolean furnished;
    private Integer yearBuilt;
    private Boolean petFriendly;
    private Boolean availabilityStatus;
    private String ownerName;
    private String ownerContact;
    private String dealType;

    private Long noOfBedrooms;
    private Long noOfBathrooms;
    private Long floorLevel;
    private Long noOfBalconies;
    private String kitchenType;
    private String livingAndDiningType;
    private String flooringType;
    private String airConditioningType;

    private Boolean elevator;
    private Boolean generator;
    private Boolean security;
    private Boolean gym;
    private Boolean pool;
    private String tenantType;

    private String schoolDistance;
    private String hospitalDistance;
    private String mainRoadDistance;

    private String gasConnection;
    private String waterAvailability;
    private Boolean cctv;
    private String OccupancyRequirements;
    private String leaseTerm;
    private String facingDirection;
    private Boolean roofTopAllowed;
    private String renovationStatus;
    private String deposit;


    private Boolean loved;

    // Hero Image (main image) field
    private String heroImage;
    // List of image URLs for additional images
    @ElementCollection
    @CollectionTable(name = "property_image_urls", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




//
//    public Properties(String location, String price, String shortDescription, String longDescription,
//                      String features, String restrictions, List<String> shortTitle,String propertyType,
//                      String propertySize,Boolean parking,Boolean furnished,Integer yearBuilt,
//                      Boolean petFriendly,Boolean availabilityStatus,String ownerName,String ownerContact,String dealType) {
//        this.location = location;
//        this.price = price;
//        this.shortDescription = shortDescription;
//        this.longDescription = longDescription;
//        this.features = features;
//        this.restrictions = restrictions;
//        this.shortTitle = shortTitle;
//        this.parking = parking;
//        this.furnished = furnished;
//        this.propertyType = propertyType;
//        this.propertySize = propertySize;
//        this.yearBuilt = yearBuilt;
//        this.petFriendly = petFriendly;
//        this.availabilityStatus = availabilityStatus;
//        this.ownerName = ownerName;
//        this.ownerContact = ownerContact;
//        this.dealType = dealType;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getShortDescription() {
//        return shortDescription;
//    }
//
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }
//
//    public String getLongDescription() {
//        return longDescription;
//    }
//
//    public void setLongDescription(String longDescription) {
//        this.longDescription = longDescription;
//    }
//
//    public String getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(String features) {
//        this.features = features;
//    }
//
//    public String getRestrictions() {
//        return restrictions;
//    }
//
//    public void setRestrictions(String restrictions) {
//        this.restrictions = restrictions;
//    }
//
//    public String getHeroImage() {
//        return heroImage;
//    }
//
//    public void setHeroImage(String heroImage) {
//        this.heroImage = heroImage;
//    }
//
//    public List<String> getImageUrls() {
//        return imageUrls;
//    }
//
//    public void setImageUrls(List<String> imageUrls) {
//        this.imageUrls = imageUrls;
//    }
//
//    public List<String> getShortTitle() {
//        return shortTitle;
//    }
//
//    public void setShortTitle(List<String> shortTitle) {
//        this.shortTitle = shortTitle;
//    }
//    // Getter and Setter for propertyType
//    public String getPropertyType() {
//        return propertyType;
//    }
//
//    public void setPropertyType(String propertyType) {
//        this.propertyType = propertyType;
//    }
//
//    // Getter and Setter for propertySize
//    public String getPropertySize() {
//        return propertySize;
//    }
//
//    public void setPropertySize(String propertySize) {
//        this.propertySize = propertySize;
//    }
//
//    // Getter and Setter for parking
//    public Boolean getParking() {
//        return parking;
//    }
//
//    public void setParking(Boolean parking) {
//        this.parking = parking;
//    }
//
//    // Getter and Setter for furnished
//    public Boolean getFurnished() {
//        return furnished;
//    }
//
//    public void setFurnished(Boolean furnished) {
//        this.furnished = furnished;
//    }
//    public Integer getYearBuilt() {
//        return yearBuilt;
//    }
//
//    public void setYearBuilt(Integer yearBuilt) {
//        this.yearBuilt = yearBuilt;
//    }
//
//    public Boolean getPetFriendly() {
//        return petFriendly;
//    }
//
//    public void setPetFriendly(Boolean petFriendly) {
//        this.petFriendly = petFriendly;
//    }
//
//    public Boolean getAvailabilityStatus() {
//        return availabilityStatus;
//    }
//
//    public void setAvailabilityStatus(Boolean availabilityStatus) {
//        this.availabilityStatus = availabilityStatus;
//    }
//
//    public String getOwnerName() {
//        return ownerName;
//    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }
//
//    public String getOwnerContact() {
//        return ownerContact;
//    }
//
//    public void setOwnerContact(String ownerContact) {
//        this.ownerContact = ownerContact;
//    }
//
//    public String getAdditionalDetails() {
//        return additionalDetails;
//    }
//
//    public void setAdditionalDetails(String additionalDetails) {
//        this.additionalDetails = additionalDetails;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getDealType() {
//        return dealType;
//    }
//
//    public void setDealType(String dealType) {
//        this.dealType = dealType;
//    }
}


