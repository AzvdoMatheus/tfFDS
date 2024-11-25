package com.fds.trabalhofinal.persistence.itfImpl;

import com.fds.trabalhofinal.domain.models.ApplicationModel;
import com.fds.trabalhofinal.domain.repository.IAppRepository;
import com.fds.trabalhofinal.persistence.Application;
import com.fds.trabalhofinal.persistence.repositories.IApplication_Rep;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IApplication_JPA implements IAppRepository {
    private final IApplication_Rep applicationRep;

    public IApplication_JPA(IApplication_Rep applicationRep) {
        this.applicationRep = applicationRep;
    }

    @Override
    public List<ApplicationModel> findAll() {
        return ((List<Application>) applicationRep.findAll()).stream()
                .map(Application::toApplicationModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ApplicationModel> findById(Long id) {
        return applicationRep.findById(id).map(Application::toApplicationModel);
    }

    @Override
    public ApplicationModel save(ApplicationModel applicationModel) {
        Application application = Application.fromApplicationModel(applicationModel);
        Application savedApplication = applicationRep.save(application);
        return Application.toApplicationModel(savedApplication);
    }

    @Override
    public void updateMonthlyCost(Long id, double newMonthlyCost) {
        Optional<Application> app = applicationRep.findById(id);
        app.ifPresent(application -> {
            application.setMonthlyCost(newMonthlyCost);
            applicationRep.save(application);
        });
    }
}
