package com.fds.trabalhofinal.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IApplication_Rep extends CrudRepository<Application, Long> {
    void ApplicationModel(Application application);
    Optional<Application> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<Application> findByClientId(Long clientId);
    List<Application> findByApplicationId(Long applicationId);
    void updatePlanEnd(Long applicationId, Date newPlanEndDate);
}