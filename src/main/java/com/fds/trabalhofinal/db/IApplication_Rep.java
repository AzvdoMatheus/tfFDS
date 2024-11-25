package com.fds.trabalhofinal.db;

import org.springframework.data.repository.CrudRepository;
import com.fds.trabalhofinal.persistence.Application;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IApplication_Rep extends CrudRepository<Application, Long> {
    Optional<Application> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<Application> findByClientId(Long clientId);
    List<Application> findByApplicationId(Long applicationId);
    void updatePlanEnd(Long applicationId, Date newPlanEndDate);
}
