package com.fds.trabalhofinal.persistence.repositories;

import com.fds.trabalhofinal.persistence.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClient_Rep extends JpaRepository<Client, Long> { }
