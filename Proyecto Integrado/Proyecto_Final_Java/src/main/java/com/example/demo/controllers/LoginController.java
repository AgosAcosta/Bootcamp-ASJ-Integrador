package com.example.demo.controllers;

import com.example.demo.dto.LoginDTO;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping()
    public boolean login(@RequestBody LoginDTO loginDTO) {
        return loginService.checkUser(loginDTO.getUser(), loginDTO.getPassword());
    }
}
