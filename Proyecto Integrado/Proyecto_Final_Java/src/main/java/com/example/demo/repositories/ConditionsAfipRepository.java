package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Conditions_Afip_Model;

public interface ConditionsAfipRepository extends JpaRepository<Conditions_Afip_Model, Integer>{
	  Optional<Conditions_Afip_Model> findByCondition(String condition);

}
