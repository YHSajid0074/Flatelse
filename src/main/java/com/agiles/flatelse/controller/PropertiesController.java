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


    @PostMapping(value = "/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> saveProperty(@ModelAttribute PropertiesRequestDto propertyRequestDTO) throws Exception {

         propertiesService.saveProperty(propertyRequestDTO,propertyRequestDTO.heroImage(),propertyRequestDTO.imageUrls());

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

//    // Endpoint to update property
//    @PutMapping("/update/{id}")
//    public Properties updateProperty(@PathVariable Long id,
//                                     @RequestParam String location,
//                                     @RequestParam String price,
//                                     @RequestParam String shortDescription,
//                                     @RequestParam String longDescription,
//                                     @RequestParam String features,
//                                     @RequestParam String restrictions,
//                                     @RequestParam String heroImage,
//                                     @RequestParam List<String> imageUrls,
//                                     @RequestParam List<String> shortTitle,
//                                     @RequestParam("file") MultipartFile file) throws Exception {
//        // Create a property object with updated data
//        Properties updatedProperty = new Properties(location, price, shortDescription, longDescription, features, restrictions, heroImage, imageUrls, shortTitle);
//        updatedProperty.setId(id);
//
//        // Update the property in the database
//        return propertiesService.updateProperty(updatedProperty, file);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertiesService.deleteProperty(id);
    }
}


