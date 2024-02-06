package com.example.demo.services;

import com.example.demo.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    private final String user= "usuario";
    private final String password = "123456";

    public boolean checkUser(String username, String passwordLogin) {
        return user.equals(username) && password.equals(passwordLogin);
    }

}
