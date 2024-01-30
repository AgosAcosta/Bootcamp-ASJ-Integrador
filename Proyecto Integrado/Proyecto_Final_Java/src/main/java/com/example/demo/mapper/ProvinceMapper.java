package com.example.demo.mapper;

import com.example.demo.dto.ProvincesDTO;
import com.example.demo.models.ProvincesModel;
import com.example.demo.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProvinceMapper {

    public static Optional<ProvincesDTO> getProvince(ProvincesModel provincesModel) {
        ProvincesDTO provinceDTO = new ProvincesDTO();
        provinceDTO.setIdProvince(provincesModel.getIdProvince());
        provinceDTO.setProvince(provincesModel.getProvince());
        provinceDTO.setCountry(provincesModel.getCountry().getCountry());
        return Optional.of(provinceDTO);
    }
}
