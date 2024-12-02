package com.fds.trabalhofinal.domain.models;

public class UserModel {
    private final String userLoginCode;
    private String userLoginPassword;

    public UserModel(String userLoginCode, String userLoginPassword) {
        this.userLoginCode = userLoginCode;
        this.userLoginPassword = userLoginPassword;
    }

    public String getUserLoginCode() { return userLoginCode; }
    public String getUserLoginPassword() { return userLoginPassword; }
}
