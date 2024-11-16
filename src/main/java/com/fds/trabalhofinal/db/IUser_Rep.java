package com.fds.trabalhofinal.db;

import org.springframework.data.repository.CrudRepository;

public interface IUser_Rep extends CrudRepository<User, Long> {
    void UserLogin(User user);
    void UserPassword(User user);
}
