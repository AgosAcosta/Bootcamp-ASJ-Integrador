package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Contacts_Model;

public interface ContactRepository extends JpaRepository<Contacts_Model, Integer> {

}
