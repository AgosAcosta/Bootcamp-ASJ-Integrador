package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginDTO {

    private int idLogin;

    @NotNull(message = "El usuario no puede estar vacio")
    private String user;

    @NotNull(message = "La contraseña no puede estar vacio")
    private String password;

    public LoginDTO(int idLogin, String user, String password) {
        this.idLogin = idLogin;
        this.user = user;
        this.password = password;
    }

    public LoginDTO() {
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
