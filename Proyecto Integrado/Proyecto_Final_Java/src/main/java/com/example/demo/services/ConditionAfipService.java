package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ConditionAfipDTO;
import com.example.demo.mapper.ConditionAfipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ConditionsAfipModel;
import com.example.demo.repositories.ConditionsAfipRepository;

@Service
public class ConditionAfipService {

	@Autowired
	ConditionsAfipRepository conditionsAfipRepository;

	/**
	 * getAllCategorySupplier --- Busca y filtra la condición ante AFIP.
	 */
	public List<ConditionAfipDTO> getAllConditionAfip(){
		List<ConditionsAfipModel> conditionsAfipModels = conditionsAfipRepository.findAll();
		List<ConditionAfipDTO> conditionAfipDTOS = new ArrayList<ConditionAfipDTO>();
		for(ConditionsAfipModel condition : conditionsAfipModels){
			conditionAfipDTOS.add(ConditionAfipMapper.getConditionAfip(condition).get());
		}
		return conditionAfipDTOS;
	}

	/**
	 * getConditionById --- Busca por ID la condición ante AFIP.
	 */
	public Optional<ConditionsAfipModel> getConditionById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("El ID de la condicion debe ser mayor que 0");
		}
		return conditionsAfipRepository.findById(id);
	}
}
