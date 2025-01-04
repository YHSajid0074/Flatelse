package com.agiles.flatelse.service;

import com.agiles.flatelse.dto.request.PropertiesRequestDto;
import com.agiles.flatelse.model.Properties;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PropertiesService {

    Properties saveProperty(PropertiesRequestDto propertiesRequestDto, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception;

    List<Properties> getAllProperties();

    Optional<Properties> getPropertyById(Long id);

    Properties updateProperty(Long id, Properties properties, MultipartFile heroImageFile, List<MultipartFile> additionalImagesFiles) throws Exception;

    void deleteProperty(Long id);
}
