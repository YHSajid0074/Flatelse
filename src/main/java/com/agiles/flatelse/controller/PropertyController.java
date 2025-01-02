package com.agiles.flatelse.controller;

import com.agiles.flatelse.model.Property;
import com.agiles.flatelse.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/properties")
public class PropertyController {


    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Get all properties
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }


    @PostMapping(value = "/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Property> addProperty(
            @RequestParam("location") String location,
            @RequestParam("price") String price,
            @RequestParam("shortDescription") String shortDescription,
            @RequestParam("longDescription") String longDescription,
            @RequestParam("features") String features,
            @RequestParam("restrictions") String restrictions,
            @RequestParam("heroImage") MultipartFile heroImage) {

        try {
            byte[] heroImageBytes = heroImage.getBytes();  // Convert image to byte array
            Property property = new Property(location, price, shortDescription, longDescription, features, restrictions, heroImageBytes);
            Property savedProperty = propertyService.addProperty(property);
            return ResponseEntity.ok(savedProperty);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // Update existing property
    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        Property updatedProperty = propertyService.updateProperty(id, propertyDetails);
        if (updatedProperty != null) {
            return ResponseEntity.ok(updatedProperty);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete property by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        if (propertyService.deleteProperty(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
