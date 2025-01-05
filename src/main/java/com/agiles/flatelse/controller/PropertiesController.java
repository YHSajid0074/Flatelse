package com.agiles.flatelse.controller;

import com.agiles.flatelse.dto.request.PropertiesRequestDto;
import com.agiles.flatelse.dto.response.PropertiesResponseDto;
import com.agiles.flatelse.model.Properties;
import com.agiles.flatelse.service.impl.PropertiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertiesController {

    @Autowired
    private PropertiesServiceImpl propertiesService;


    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> saveProperty(@ModelAttribute PropertiesRequestDto propertyRequestDTO) throws Exception {

        propertiesService.saveProperty(propertyRequestDTO, propertyRequestDTO.heroImage(), propertyRequestDTO.imageUrls());

        return ResponseEntity.ok("Successfully Created");
    }


    @GetMapping("/all")
    public List<PropertiesResponseDto> getAllProperties() {
        return propertiesService.getAllProperties();
    }


    @GetMapping("/{id}")
    public PropertiesResponseDto getPropertyById(@PathVariable Long id) {
        return propertiesService.getPropertyById(id).get();
    }

    @PutMapping("Update")
    public ResponseEntity<String> UpdateProperties(@RequestParam Long id, PropertiesRequestDto propertyRequestDTO) throws Exception {
        propertiesService.updateProperty(id, propertyRequestDTO);
        return ResponseEntity.ok("Successfully Updated");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertiesService.deleteProperty(id);
    }

    @GetMapping("/search-by-parking")
    public ResponseEntity<List<PropertiesResponseDto>> searchByParking(@RequestParam("parking") Boolean parking) {
        List<PropertiesResponseDto> properties = propertiesService.searchByParking(parking);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("/search-by-furnished")
    public ResponseEntity<List<PropertiesResponseDto>> searchByFurnished(@RequestParam("furnished") Boolean furnished) {
        List<PropertiesResponseDto> properties = propertiesService.searchByFurnished(furnished);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("/search-by-property-type")
    public ResponseEntity<List<PropertiesResponseDto>> searchByPropertyType(@RequestParam("propertyType") String propertyType) {
        List<PropertiesResponseDto> properties = propertiesService.searchByPropertyType(propertyType);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("/search-by-location")
    public ResponseEntity<List<PropertiesResponseDto>> searchByLocation(@RequestParam("location") String location) {
        List<PropertiesResponseDto> properties = propertiesService.searchByLocation(location);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("/search-by-pet-friendly")
    public ResponseEntity<List<PropertiesResponseDto>> searchByPetFriendly(@RequestParam("petFriendly") Boolean petFriendly) {
        List<PropertiesResponseDto> properties = propertiesService.searchByPetFriendly(petFriendly);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }
}


