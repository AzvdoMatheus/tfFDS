package com.fds.trabalhofinal.domain.models;

public class UserModel {

    private String userLoginPassword;
    private String userLoginCode;
    public UserModel(String userLoginCode) {
        this.userLoginCode = userLoginCode;
    }

    public String getUserLoginCode() { return userLoginCode; }

    public void setUserLoginCode(String userLoginCode) { this.userLoginCode = userLoginCode; }

    public String getUserLoginPassword() { return userLoginPassword; }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }
}
