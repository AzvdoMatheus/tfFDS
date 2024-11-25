package com.fds.trabalhofinal.domain.models;

public class UserModel {
    private final long userIdentificationCode;
    private final String userLoginCode;
    private String userLoginPassword;

    public UserModel(long userIdentificationCode, String userLoginCode, String userLoginPassword) {
        this.userIdentificationCode = userIdentificationCode;
        this.userLoginCode = userLoginCode;
        this.userLoginPassword = userLoginPassword;
    }

    public long getUserIdentificationCode() { return userIdentificationCode; }

    public String getUserLoginCode() { return userLoginCode; }

    public String getUserLoginPassword() { return userLoginPassword; }

    public void updatePassword(String newPassword) {
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        this.userLoginPassword = newPassword;
    }
}
