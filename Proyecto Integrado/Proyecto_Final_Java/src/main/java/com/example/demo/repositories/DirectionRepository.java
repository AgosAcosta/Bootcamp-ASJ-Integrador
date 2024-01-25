package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Directions_Model;

public interface DirectionRepository extends JpaRepository<Directions_Model, Integer> {

}
