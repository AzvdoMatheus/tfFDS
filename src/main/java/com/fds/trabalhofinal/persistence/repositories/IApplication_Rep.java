package com.fds.trabalhofinal.persistence.repositories;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.fds.trabalhofinal.persistence.Application;

import java.util.Optional;

@Repository
public interface IApplication_Rep extends JpaRepository<Application, Long> {

    Optional<Application> findById(Long applicationId);
}
