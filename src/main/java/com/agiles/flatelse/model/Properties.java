package com.agiles.flatelse.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String price;
    private String shortDescription;
    private String longDescription;
    private String features;
    private String restrictions;

    // Hero Image (main image) field
    private String heroImage;

    // List of image URLs for additional images
    @ElementCollection
    @CollectionTable(name = "property_image_urls", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    // List of short titles for each additional image
    @ElementCollection
    @CollectionTable(name = "property_image_titles", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "short_title")
    private List<String> shortTitle;

    public Properties() {}

    public Properties(String location, String price, String shortDescription, String longDescription,
                      String features, String restrictions, List<String> shortTitle) {
        this.location = location;
        this.price = price;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.features = features;
        this.restrictions = restrictions;
        this.shortTitle = shortTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<String> getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(List<String> shortTitle) {
        this.shortTitle = shortTitle;
    }
}


