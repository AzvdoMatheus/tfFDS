package com.fds.trabalhofinal.services.useCases;

import com.fds.trabalhofinal.domain.models.ApplicationModel;
import com.fds.trabalhofinal.domain.repository.IAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServices {

    private final IAppRepository appRepository;

    @Autowired
    public ApplicationServices(IAppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public ApplicationModel createApplication(String appName, double monthlyCost) {
        ApplicationModel newApplication = new ApplicationModel(0L, appName, monthlyCost);
        return appRepository.save(newApplication);
    }

    public void updateMonthlyCost(Long appId, double newMonthlyCost) {
        appRepository.updateMonthlyCost(appId, newMonthlyCost);
    }

    public List<ApplicationModel> listAllApplications() {
        return appRepository.findAll();
    }

    public Optional<ApplicationModel> getApplicationById(Long appId) {
        return appRepository.findById(appId);
    }
}
