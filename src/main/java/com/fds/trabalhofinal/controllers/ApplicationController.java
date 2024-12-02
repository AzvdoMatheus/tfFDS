package com.fds.trabalhofinal.controllers;

import com.fds.trabalhofinal.services.useCases.ApplicationServices;
import com.fds.trabalhofinal.domain.models.ApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationServices applicationServices;

    @Autowired
    public ApplicationController(ApplicationServices applicationServices) {
        this.applicationServices = applicationServices;
    }

    @GetMapping
    public ResponseEntity<List<ApplicationModel>> listAllApplications() {
        List<ApplicationModel> applications = applicationServices.listAllApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationModel> getApplicationById(@PathVariable Long id) {
        return applicationServices.getApplicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
