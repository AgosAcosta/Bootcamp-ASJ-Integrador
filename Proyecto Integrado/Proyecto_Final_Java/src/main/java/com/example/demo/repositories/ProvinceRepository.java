package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.CountriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ProvincesModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvinceRepository extends JpaRepository<ProvincesModel, Integer>{

	Optional<ProvincesModel> findByProvince(String province);

	List<ProvincesModel> findByCountry(CountriesModel country);

}
