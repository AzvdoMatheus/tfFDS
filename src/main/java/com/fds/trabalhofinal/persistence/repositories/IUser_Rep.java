package com.fds.trabalhofinal.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fds.trabalhofinal.persistence.User;

@Repository
public interface IUser_Rep extends CrudRepository<User, Long> { }
