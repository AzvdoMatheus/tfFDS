package com.fds.trabalhofinal.persistence.repositories;
import org.springframework.data.repository.CrudRepository;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.fds.trabalhofinal.persistence.Application;

import java.util.Optional;

@Repository
public interface IApplication_Rep extends CrudRepository<Application, Long> {
    @SuppressWarnings("null")
    Optional<Application> findById(@NonNull Long applicationId);
}