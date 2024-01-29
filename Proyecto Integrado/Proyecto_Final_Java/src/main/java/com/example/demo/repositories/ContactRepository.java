package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ContactsModel;

public interface ContactRepository extends JpaRepository<ContactsModel, Integer> {

}
