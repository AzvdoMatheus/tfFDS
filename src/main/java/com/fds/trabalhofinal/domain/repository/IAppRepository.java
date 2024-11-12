package com.fds.trabalhofinal.domain.repository;

import java.util.List;
import java.util.Optional;
import com.fds.trabalhofinal.domain.models.ApplicationModel;

public interface IAppRepository {
    List<ApplicationModel> findAll();
    Optional<ApplicationModel> findById(Long id);

    // cadastra um novo aplicativo
    ApplicationModel addNewApplication(ApplicationModel application);
    void updateMonthlyCost(Long id, Double newMonthlyCost);
}
