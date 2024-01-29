package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.DirectionsModel;

public interface DirectionRepository extends JpaRepository<DirectionsModel, Integer> {

}
