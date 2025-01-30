package com.agiles.flatelse.service;

import com.agiles.flatelse.dto.request.PropertiesRequestDto;
import com.agiles.flatelse.dto.response.IPropertiesResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PropertiesService {

    void saveProperty(PropertiesRequestDto propertiesRequestDto, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception;

    List<IPropertiesResponseDto> getAllProperties(String dealType);

    Optional<IPropertiesResponseDto> getPropertyById(Long id);

    void updateProperty(Long id, PropertiesRequestDto propertiesRequestDto) throws Exception;

    void deleteProperty(Long id);

    List<IPropertiesResponseDto> getPropertiesByUserId(Long userId);
    Long getPropertiesCountByUserId(Long userId);

}
