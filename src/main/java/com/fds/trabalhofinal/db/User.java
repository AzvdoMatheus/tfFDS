package com.fds.trabalhofinal.db;

import com.fds.trabalhofinal.domain.models.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userIdentificationCode;
    private String userLoginPassword;
    private String userLoginCode;

    public User() {
    }

    public User(String userLoginCode, String userLoginPassword) {
        this.userLoginCode = userLoginCode;
        this.userLoginPassword = userLoginPassword;
    }

    public long getUserIdentificationCode() {
        return userIdentificationCode;
    }

    public String getUserLoginCode() {
        return userLoginCode;
    }

    public void setUserLoginCode(String userLoginCode) {
        this.userLoginCode = userLoginCode;
    }

    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public static User fromUserModel(UserModel uModel) {
        User user = new User();
        user.setUserIdentificationCode(uModel.getUserIdentificationCode());
        user.setUserLoginCode(uModel.getUserLoginCode());
        user.setUserLoginPassword(uModel.getUserLoginPassword());
        return user;
    }

    public static UserModel toUserModel(User user) {
        UserModel uModel = new UserModel();
        uModel.setUserIdentificationCode(user.getUserIdentificationCode());
        uModel.setUserLoginCode(user.getUserLoginCode());
        uModel.setUserLoginPassword(user.getUserLoginPassword());
        return uModel;
    }
}