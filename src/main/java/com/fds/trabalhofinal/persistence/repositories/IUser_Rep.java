package com.fds.trabalhofinal.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fds.trabalhofinal.persistence.User;

@Repository
public interface IUser_Rep extends JpaRepository<User, Long> { }
