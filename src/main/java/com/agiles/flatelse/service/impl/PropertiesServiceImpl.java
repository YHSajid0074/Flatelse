package com.agiles.flatelse.service.impl;

import com.agiles.flatelse.auth.repository.UserRepo;
import com.agiles.flatelse.config.page.PageData;
import com.agiles.flatelse.dto.request.PropertiesRequestDto;
import com.agiles.flatelse.dto.request.PropertiesSearchDto;
import com.agiles.flatelse.dto.response.IPropertiesResponseDto;
import com.agiles.flatelse.dto.response.PropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
import com.agiles.flatelse.repository.PropertyRepository;
import com.agiles.flatelse.service.CloudneryImageService;
import com.agiles.flatelse.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private CloudneryImageService cloudneryImageService;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepo userRepo;


    public void saveProperty(PropertiesRequestDto propertiesRequestDto, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception {

        Properties propertyEntity = convertToEntity(new Properties(), heroImageFile, additionalImagesFiles, propertiesRequestDto);

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
        properties.setLocation(propertiesRequestDto.location());
        properties.setPrice(propertiesRequestDto.price());
        properties.setPriceType(propertiesRequestDto.priceType());
        properties.setShortDescription(propertiesRequestDto.shortDescription());
        properties.setLongDescription(propertiesRequestDto.longDescription());
        properties.setRestrictions(propertiesRequestDto.restrictions());

        properties.setPropertyType(propertiesRequestDto.propertyType());
        properties.setPropertySize(propertiesRequestDto.propertySize());
        properties.setParking(propertiesRequestDto.parking());
        properties.setFurnished(propertiesRequestDto.furnished());
        properties.setYearBuilt(propertiesRequestDto.yearBuilt());
        properties.setPetFriendly(propertiesRequestDto.petFriendly());
        properties.setAvailabilityStatus(propertiesRequestDto.availabilityStatus());
        properties.setOwnerName(propertiesRequestDto.ownerName());
        properties.setOwnerContact(propertiesRequestDto.ownerContact());
        properties.setDealType(propertiesRequestDto.dealType());

        properties.setNoOfBedrooms(propertiesRequestDto.noOfBedrooms());
        properties.setNoOfBathrooms(propertiesRequestDto.noOfBathrooms());
        properties.setFloorLevel(propertiesRequestDto.floorLevel());
        properties.setNoOfBalconies(propertiesRequestDto.noOfBalconies());
        properties.setKitchenType(propertiesRequestDto.kitchenType());
        properties.setLivingAndDiningType(propertiesRequestDto.livingAndDiningType());
        properties.setFlooringType(propertiesRequestDto.flooringType());
        properties.setAirConditioningType(propertiesRequestDto.airConditioningType());

        properties.setElevator(propertiesRequestDto.elevator());
        properties.setGenerator(propertiesRequestDto.generator());
        properties.setSecurity(propertiesRequestDto.security());
        properties.setGym(propertiesRequestDto.gym());
        properties.setPool(propertiesRequestDto.pool());
        properties.setTenantType(propertiesRequestDto.tenantType());

        properties.setSchoolDistance(propertiesRequestDto.schoolDistance());
        properties.setHospitalDistance(propertiesRequestDto.hospitalDistance());
        properties.setMainRoadDistance(propertiesRequestDto.mainRoadDistance());

        properties.setGasConnection(propertiesRequestDto.gasConnection());
        properties.setWaterAvailability(propertiesRequestDto.waterAvailability());
        properties.setCctv(propertiesRequestDto.cctv());
        properties.setOccupancyRequirements(propertiesRequestDto.occupancyRequirements());
        properties.setLeaseTerm(propertiesRequestDto.leaseTerm());
        properties.setFacingDirection(propertiesRequestDto.facingDirection());
        properties.setRoofTopAllowed(propertiesRequestDto.roofTopAllowed());
        properties.setRenovationStatus(propertiesRequestDto.renovationStatus());
        properties.setDeposit(propertiesRequestDto.deposit());
        return properties;

    }


    @Override
    public List<IPropertiesResponseDto> getAllProperties(String dealType) {
        return propertyRepository.getAllProperties(dealType);
    }


    @Override
    public Optional<IPropertiesResponseDto> getPropertyById(Long id) {
        return propertyRepository.getPropertiesById(id);
    }

    @Override
    public void updateProperty(Long id, PropertiesRequestDto propertiesRequestDto) throws Exception {
        Properties properties1 = propertyRepository.findById(id).get();
        Properties update = convertForUpdate(properties1, propertiesRequestDto);
        propertyRepository.save(update);
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

    private Properties convertForUpdate(Properties properties, PropertiesRequestDto propertiesRequestDto) throws Exception {

//        Map<String, Object> heroUploadResult = cloudneryImageService.upload(propertiesRequestDto.heroImage());
//        String heroImageUrl = (String) heroUploadResult.get("secure_url");
//
//
//        List<String> imageUrls = new ArrayList<>();
//        for (MultipartFile file : propertiesRequestDto.imageUrls()) {
//            Map<String, Object> uploadResult = cloudneryImageService.upload(file);
//            String imageUrl = (String) uploadResult.get("secure_url");
//            imageUrls.add(imageUrl);
//        }

//
//        properties.setHeroImage(heroImageUrl);
//        properties.setImageUrls(imageUrls);
//        properties.setPrice(propertiesRequestDto.price());
//        properties.setLocation(propertiesRequestDto.location());
//        properties.setFeatures(propertiesRequestDto.features());
//        properties.setRestrictions(propertiesRequestDto.restrictions());
//        properties.setLongDescription(propertiesRequestDto.longDescription());
//        properties.setShortDescription(propertiesRequestDto.shortDescription());
//        properties.setPropertySize(propertiesRequestDto.propertySize());
//        properties.setPropertyType(propertiesRequestDto.propertyType());
//        properties.setYearBuilt(propertiesRequestDto.yearBuilt());
//        properties.setPetFriendly(propertiesRequestDto.petFriendly());
//        properties.setAvailabilityStatus(propertiesRequestDto.availabilityStatus());
//        properties.setParking(propertiesRequestDto.parking());
//        properties.setOwnerName(propertiesRequestDto.ownerName());
//        properties.setOwnerContact(propertiesRequestDto.ownerContact());
//        properties.setFurnished(propertiesRequestDto.furnished());
//        properties.setAdditionalDetails(propertiesRequestDto.additionalDetails());
//        properties.setUser(userRepo.findById(propertiesRequestDto.userId()).orElse(null));
        properties.setDealType(propertiesRequestDto.dealType());
        return properties;
    }

    private PageData toPageData(Page<?> data) {
        PageData pageData = new PageData();
        pageData.setModel(data.getContent());
        pageData.setTotalElements(data.getTotalElements());
        pageData.setTotalPages(data.getTotalPages());
        pageData.setCurrentPage(data.getNumber());
        return pageData;
    }

    public PageData search(PropertiesSearchDto propertiesSearchDto) {
        int pageNumber = Objects.nonNull(propertiesSearchDto.getPageNumber()) ? propertiesSearchDto.getPageNumber() : 1;
        int pageSize = Objects.nonNull(propertiesSearchDto.getPageSize()) ? propertiesSearchDto.getPageSize() : 20;

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

        Page<IPropertiesResponseDto> properties = propertyRepository.search(
                propertiesSearchDto.getLocation(),
                propertiesSearchDto.getPrice(),
                propertiesSearchDto.getPropertyType(),
                propertiesSearchDto.getPropertySize(),
                propertiesSearchDto.getParking(),
                propertiesSearchDto.getFurnished(),
                propertiesSearchDto.getPetFriendly(),
                propertiesSearchDto.getDealType(),
                pageable
        );
        return toPageData(properties);
    }


    public List<IPropertiesResponseDto>search1(PropertiesSearchDto propertiesSearchDto) {
        return propertyRepository.search1(
                propertiesSearchDto.getLocation(),
                propertiesSearchDto.getPrice(),
                propertiesSearchDto.getPropertyType(),
                propertiesSearchDto.getPropertySize(),
                propertiesSearchDto.getParking(),
                propertiesSearchDto.getFurnished(),
                propertiesSearchDto.getPetFriendly(),
                propertiesSearchDto.getDealType()
        );
    }

}
