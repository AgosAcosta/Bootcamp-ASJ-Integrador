package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Provinces_Model;

public interface ProvinceRepository extends JpaRepository<Provinces_Model, Integer>{

	Optional<Provinces_Model> findByProvince(String province);

}
