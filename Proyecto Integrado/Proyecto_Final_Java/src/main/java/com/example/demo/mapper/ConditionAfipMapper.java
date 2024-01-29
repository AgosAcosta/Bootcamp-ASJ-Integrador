package com.example.demo.mapper;


import com.example.demo.dto.ConditionAfipDTO;
import com.example.demo.models.ConditionsAfipModel;

import java.util.Optional;

public class ConditionAfipMapper {
    public static Optional<ConditionAfipDTO> getConditionAfip(ConditionsAfipModel conditionsAfipModel) {
        ConditionAfipDTO conditionAfipDTO = new ConditionAfipDTO();
        conditionAfipDTO.setIdConditionAfip(conditionsAfipModel.getIdConditionAfip());
        conditionAfipDTO.setConditionAfip(conditionsAfipModel.getCondition());
        return Optional.of(conditionAfipDTO);
    }
}

