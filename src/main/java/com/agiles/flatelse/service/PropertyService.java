package com.agiles.flatelse.service;

import com.agiles.flatelse.model.Property;
import com.agiles.flatelse.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // Get all properties
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // Add new property
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Update existing property
    public Property updateProperty(Long id, Property propertyDetails) {
        if (propertyRepository.existsById(id)) {
            propertyDetails.setId(id);
            return propertyRepository.save(propertyDetails);
        }
        return null; // Or handle with an exception
    }

    // Delete property by id
    public boolean deleteProperty(Long id) {
        if (propertyRepository.existsById(id)) {
            propertyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

