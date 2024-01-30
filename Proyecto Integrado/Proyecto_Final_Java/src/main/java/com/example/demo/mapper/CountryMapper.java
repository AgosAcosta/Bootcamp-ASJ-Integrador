package com.example.demo.mapper;

import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.DetailsPurchaseOrderDTO;
import com.example.demo.dto.ProvincesDTO;
import com.example.demo.dto.SupplierResponseDTO;
import com.example.demo.models.CountriesModel;
import com.example.demo.models.DetailsPurchaseOrdersModel;
import com.example.demo.models.ProvincesModel;
import com.example.demo.models.SuppliersModel;
import com.example.demo.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryMapper {

    public static Optional<CountryDTO> getCountry(CountriesModel countriesModel) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setIdCountry(countriesModel.getIdCountry());
        countryDTO.setCountry(countriesModel.getCountry());

        return Optional.of(countryDTO);
    }

//    public static List<ProvincesDTO> mapProvince(List<ProvincesModel> listProvinces){
//
//        List<ProvincesDTO> dtoList = new ArrayList<>();
//        for (ProvincesModel provincesModel: listProvinces){
//            ProvincesDTO provincesDTO = new ProvincesDTO();
//            provincesDTO.setIdProvince(provincesModel.getIdProvince());
//            provincesDTO.setProvince(provincesModel.getProvince());
//            provincesDTO.setCountry(provincesModel.getCountry().getCountry());
//            dtoList.add(provincesDTO);
//        }
//        return dtoList;
//    }
}
