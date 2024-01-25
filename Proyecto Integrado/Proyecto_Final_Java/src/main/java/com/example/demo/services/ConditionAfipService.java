package com.example.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Conditions_Afip_Model;
import com.example.demo.repositories.ConditionsAfipRepository;

@Service
public class ConditionAfipService {

	ConditionsAfipRepository conditionsAfipRepository;
	
	public Optional<Conditions_Afip_Model> getConditionById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("El ID de la condicion debe ser mayor que 0");
		}
		return conditionsAfipRepository.findById(id);
	}
}
