package com.fds.trabalhofinal.db;

import org.springframework.data.repository.CrudRepository;
import com.fds.trabalhofinal.persistence.Client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IClient_Rep extends CrudRepository<Client, Long> {
    Optional<Client> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<Client> findByClientId(Long clientId);
    List<Client> findByApplicationId(Long applicationId);
    void updatePlanEnd(Long clientId, Date newPlanEndDate);
}
