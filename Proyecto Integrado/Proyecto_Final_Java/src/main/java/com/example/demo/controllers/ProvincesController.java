package com.example.demo.controllers;

import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.ProvincesDTO;
import com.example.demo.dto.SupplierResponseDTO;
import com.example.demo.services.ProvinceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ubication")
public class ProvincesController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping()
    public ResponseEntity<List<CountryDTO>> getAllCountry() {
        return ResponseEntity.ok(provinceService.getAllCountry());
    }

    @GetMapping("/{countryId}/provinces")
    public ResponseEntity<List<ProvincesDTO>> getProvincesByCountryId(@PathVariable int countryId) {
        try {
            List<ProvincesDTO> provinces = provinceService.getProvincesByCountryId(countryId);
            return new ResponseEntity<>(provinces, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
