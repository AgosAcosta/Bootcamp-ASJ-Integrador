package com.example.demo.services;

import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.ProvincesDTO;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.mapper.ProvinceMapper;
import com.example.demo.models.CountriesModel;
import com.example.demo.models.ProvincesModel;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.ProvinceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    ProvinceRepository provinceRepository;

    /**
     * getAllCountry --- Busca los países.
     */
    public List<CountryDTO> getAllCountry() {
        List<CountriesModel> countriesModels = countryRepository.findAll();
        List<CountryDTO> responseDTO = new ArrayList<CountryDTO>();

        for (CountriesModel country : countriesModels) {
            responseDTO.add(CountryMapper.getCountry(country).get());
        }
        return responseDTO;
    }

    /**
     * getProvincesByCountryId --- Busca y filtra las provincias del país enviado por ID
     */
    public List<ProvincesDTO> getProvincesByCountryId(int countryId) {
        Optional<CountriesModel> countryOptional = countryRepository.findById(countryId);

        if (countryOptional.isPresent()) {
            CountriesModel country = countryOptional.get();
            List<ProvincesModel> provincesModels = provinceRepository.findByCountry(country);
            List<ProvincesDTO> responseDTO = new ArrayList<>();

            for (ProvincesModel province : provincesModels) {
                responseDTO.add(ProvinceMapper.getProvince(province).get());
            }
            return responseDTO;
        } else {
            throw new EntityNotFoundException("País no encontrado con ID: " + countryId);
        }
    }

}
