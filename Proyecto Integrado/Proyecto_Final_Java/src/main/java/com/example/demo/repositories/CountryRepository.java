package com.example.demo.repositories;

import com.example.demo.models.CountriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountriesModel,Integer> {
}
