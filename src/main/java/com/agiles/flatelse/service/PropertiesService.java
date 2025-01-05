package com.agiles.flatelse.service;

import com.agiles.flatelse.dto.request.PropertiesRequestDto;
import com.agiles.flatelse.dto.response.PropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PropertiesService {

    void saveProperty(PropertiesRequestDto propertiesRequestDto, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception;

    List<PropertiesResponseDto> getAllProperties();

    Optional<PropertiesResponseDto> getPropertyById(Long id);

    void updateProperty(Long id, PropertiesRequestDto propertiesRequestDto) throws Exception;

    void deleteProperty(Long id);

    List<PropertiesResponseDto> searchByParking(Boolean parking);

    List<PropertiesResponseDto> searchByFurnished(Boolean furnished);

    List<PropertiesResponseDto> searchByPropertyType(String propertyType);

    List<PropertiesResponseDto> searchByLocation(String location);

    List<PropertiesResponseDto> searchByPetFriendly(Boolean petFriendly);
}
