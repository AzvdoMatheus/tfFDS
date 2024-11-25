package com.fds.trabalhofinal.domain.repository;

import java.util.List;
import java.util.Optional;
import com.fds.trabalhofinal.domain.models.ApplicationModel;

public interface IAppRepository {
    List<ApplicationModel> findAll();
    Optional<ApplicationModel> findById(Long id);

    ApplicationModel save(ApplicationModel application);
    void updateMonthlyCost(Long id, double newMonthlyCost);
}
