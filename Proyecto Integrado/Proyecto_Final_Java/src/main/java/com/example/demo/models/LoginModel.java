package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class LoginModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_login", unique = true, nullable = false)
    private Integer idLogin;

    @Column(name="userName",nullable = false)
    private String userName;

    @Column(name="password",nullable = false)
    private String password;


    public LoginModel() {
    }

    public LoginModel(Integer idLogin, String userName, String password) {
        this.idLogin = idLogin;
        this.userName = userName;
        this.password = password;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
