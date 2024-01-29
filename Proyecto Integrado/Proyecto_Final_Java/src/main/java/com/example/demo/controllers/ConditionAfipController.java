package com.example.demo.controllers;

import com.example.demo.dto.CategoriesProductDTO;
import com.example.demo.dto.ConditionAfipDTO;
import com.example.demo.repositories.ConditionsAfipRepository;
import com.example.demo.services.ConditionAfipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/conditionAfip")
public class ConditionAfipController {

    @Autowired
    ConditionAfipService conditionAfipService;
    @GetMapping()
    public ResponseEntity<List<ConditionAfipDTO>> getAllConditionAfip() {
        return ResponseEntity.ok(conditionAfipService.getAllConditionAfip());
    }
}
