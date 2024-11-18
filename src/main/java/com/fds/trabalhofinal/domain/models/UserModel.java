package com.fds.trabalhofinal.domain.models;

public class UserModel {

    private String userLoginPassword;
    private long userIdentificationCode;
    private String userLoginCode;
    public UserModel(long userIdentificationCode, String userLoginCode, String userLoginPassword) {
        this.userIdentificationCode = userIdentificationCode;
        this.userLoginPassword = userLoginPassword;
        this.userLoginCode = userLoginCode;
    }

    public String getUserLoginCode() { return userLoginCode; }

    public void setUserLoginCode(String userLoginCode) { this.userLoginCode = userLoginCode; }

    public String getUserLoginPassword() { return userLoginPassword; }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public long getUserIdentificationCode() {
        return userIdentificationCode;
    }

    public void setUserIdentificationCode(long userIdentificationCode) {
        this.userIdentificationCode = userIdentificationCode;
    }
}
