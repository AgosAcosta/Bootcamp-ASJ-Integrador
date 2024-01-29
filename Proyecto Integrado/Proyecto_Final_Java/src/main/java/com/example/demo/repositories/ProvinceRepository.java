package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ProvincesModel;

public interface ProvinceRepository extends JpaRepository<ProvincesModel, Integer>{

	Optional<ProvincesModel> findByProvince(String province);

}
