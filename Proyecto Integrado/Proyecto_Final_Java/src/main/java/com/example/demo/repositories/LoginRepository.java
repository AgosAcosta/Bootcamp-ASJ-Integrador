package com.example.demo.repositories;

import com.example.demo.models.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
}
