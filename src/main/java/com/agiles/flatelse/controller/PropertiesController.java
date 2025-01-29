package com.agiles.flatelse.controller;

import com.agiles.flatelse.config.page.PageData;
import com.agiles.flatelse.dto.request.PropertiesRequestDto;
import com.agiles.flatelse.dto.request.PropertiesSearchDto;
import com.agiles.flatelse.dto.response.IPropertiesResponseDto;
import com.agiles.flatelse.service.impl.PropertiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public IPropertiesResponseDto getPropertyById(@PathVariable Long id) {
        return propertiesService.getPropertyById(id).get();
    }

    @PutMapping(value = "/update", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> UpdateProperties(@RequestParam Long id,@ModelAttribute PropertiesRequestDto propertyRequestDTO) throws Exception {
        propertiesService.updateProperty(id, propertyRequestDTO);
        return ResponseEntity.ok("Successfully Updated");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertiesService.deleteProperty(id);
    }

//    @PostMapping("search")
//    public ResponseEntity<PageData>search(@RequestBody PropertiesSearchDto requestDto) {
//        return ResponseEntity.ok(propertiesService.search(requestDto));
//    }


    @GetMapping("getAll/{dealType}")
    public ResponseEntity<List<IPropertiesResponseDto>> getAllProperties(@PathVariable String dealType) {
        return ResponseEntity.ok(propertiesService.getAllProperties(dealType));
    }


    @PostMapping("search")
    public ResponseEntity<List<IPropertiesResponseDto>> getAllBySearch(@RequestBody  PropertiesSearchDto propertiesSearchDto) {
        return ResponseEntity.ok(propertiesService.search1(propertiesSearchDto));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<IPropertiesResponseDto>> findPropertiesByUserId(@PathVariable Long userId) {
      return ResponseEntity.ok(propertiesService.getPropertiesByUserId(userId));
    }

}


