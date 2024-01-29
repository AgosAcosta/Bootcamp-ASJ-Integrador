package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ConditionsAfipModel;

public interface ConditionsAfipRepository extends JpaRepository<ConditionsAfipModel, Integer>{
	  Optional<ConditionsAfipModel> findByCondition(String condition);

}
