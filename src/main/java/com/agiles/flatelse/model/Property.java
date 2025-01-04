//package com.agiles.flatelse.model;
//
////import jakarta.persistence.*;
////import lombok.AllArgsConstructor;
////import lombok.Getter;
////import lombok.NoArgsConstructor;
////import lombok.Setter;
////@AllArgsConstructor
////@Entity
////@Getter
////@Setter
////public class Property {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////    private String location;
////    private String price;
////    private String shortDescription;
////    private String longDescription;
////    private String features;
////    private String restrictions;
////
////    @Lob
////    private byte[] heroImage;
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////
////
////    public String getLocation() {
////        return location;
////    }
////
////    public void setLocation(String location) {
////        this.location = location;
////    }
////
////    // Getter and Setter for price
////    public String getPrice() {
////        return price;
////    }
////
////    public void setPrice(String price) {
////        this.price = price;
////    }
////
////    // Getter and Setter for shortDescription
////    public String getShortDescription() {
////        return shortDescription;
////    }
////
////    public void setShortDescription(String shortDescription) {
////        this.shortDescription = shortDescription;
////    }
////
////    // Getter and Setter for longDescription
////    public String getLongDescription() {
////        return longDescription;
////    }
////
////    public void setLongDescription(String longDescription) {
////        this.longDescription = longDescription;
////    }
////
////    // Getter and Setter for features
////    public String getFeatures() {
////        return features;
////    }
////
////    public void setFeatures(String features) {
////        this.features = features;
////    }
////
////    // Getter and Setter for restrictions
////    public String getRestrictions() {
////        return restrictions;
////    }
////
////    public void setRestrictions(String restrictions) {
////        this.restrictions = restrictions;
////    }
////
////    // Getter and Setter for heroImage (byte array)
////    public byte[] getHeroImage() {
////        return heroImage;
////    }
////
////    public void setHeroImage(byte[] heroImage) {
////        this.heroImage = heroImage;
////    }
////    public Property() {
////        // No-args constructor
////    }
////
////    public Property( String location, String price, String shortDescription,
////                    String longDescription, String features, String restrictions, byte[] heroImage) {
////
////        this.location = location;
////        this.price = price;
////        this.shortDescription = shortDescription;
////        this.longDescription = longDescription;
////        this.features = features;
////        this.restrictions = restrictions;
////        this.heroImage = heroImage;
////    }
//
//
//}
