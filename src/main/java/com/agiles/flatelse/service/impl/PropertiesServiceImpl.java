package com.agiles.flatelse.service.impl;

import com.agiles.flatelse.dto.request.PropertiesRequestDto;
import com.agiles.flatelse.dto.response.PropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
import com.agiles.flatelse.repository.PropertyRepository;
import com.agiles.flatelse.service.CloudneryImageService;
import com.agiles.flatelse.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private CloudneryImageService cloudneryImageService;

    @Autowired
    private PropertyRepository propertyRepository;


    public void saveProperty(PropertiesRequestDto propertiesRequestDto, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception {

        Properties propertyEntity = convertToEntity(new Properties(), heroImageFile, additionalImagesFiles,propertiesRequestDto);

        propertyRepository.save(propertyEntity);
    }


    private Properties convertToEntity(Properties properties, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles, PropertiesRequestDto propertiesRequestDto) throws Exception {
        // Upload the hero image to Cloudinary
        Map<String, Object> heroUploadResult = cloudneryImageService.upload(heroImageFile);
        String heroImageUrl = (String) heroUploadResult.get("secure_url");

        // Upload additional images to Cloudinary and get their URLs
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : additionalImagesFiles) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(file);
            String imageUrl = (String) uploadResult.get("secure_url");
            imageUrls.add(imageUrl);
        }


        properties.setHeroImage(heroImageUrl);
        properties.setImageUrls(imageUrls);
        properties.setPrice(propertiesRequestDto.price());
        properties.setLocation(propertiesRequestDto.location());
        properties.setFeatures(propertiesRequestDto.features());
        properties.setRestrictions(propertiesRequestDto.restrictions());
        properties.setLongDescription(propertiesRequestDto.longDescription());
        properties.setShortDescription(propertiesRequestDto.shortDescription());
        return properties;

    }


    @Override
    public List<PropertiesResponseDto> getAllProperties() {
        return propertyRepository.getAllProperties();
    }


    @Override
    public Optional<PropertiesResponseDto> getPropertyById(Long id) {
        return propertyRepository.getPropertiesById(id);
    }

    @Override
    public PropertiesResponseDto updateProperty(Long id, Properties properties, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception {
        return null;
    }


//    @Override
//    public Properties updateProperty(Long id, Properties properties, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception {
//
//        Optional<Properties> existingProperty = propertyRepository.findById(id);
//        if (existingProperty.isPresent()) {
//            Properties updatedProperty = existingProperty.get();
//
//
//            updatedProperty.setLocation(properties.getLocation());
//            updatedProperty.setPrice(properties.getPrice());
//            updatedProperty.setShortDescription(properties.getShortDescription());
//            updatedProperty.setLongDescription(properties.getLongDescription());
//            updatedProperty.setFeatures(properties.getFeatures());
//            updatedProperty.setRestrictions(properties.getRestrictions());
//
//
//            if (heroImageFile != null) {
//                Map<String, Object> heroUploadResult = cloudneryImageService.upload(heroImageFile);
//                String heroImageUrl = (String) heroUploadResult.get("secure_url");
//                updatedProperty.setHeroImage(heroImageUrl);
//            }
//
//
//            if (additionalImagesFiles != null && !additionalImagesFiles.isEmpty()) {
//                updatedProperty.getImageUrls().clear();
//                for (MultipartFile file : additionalImagesFiles) {
//                    Map<String, Object> uploadResult = cloudneryImageService.upload(file);
//                    String imageUrl = (String) uploadResult.get("secure_url");
//                    updatedProperty.getImageUrls().add(imageUrl);
//                }
//            }
//
//            return propertyRepository.save(updatedProperty);
//        } else {
//            throw new RuntimeException("Property not found for id: " + id);
//        }
//    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
