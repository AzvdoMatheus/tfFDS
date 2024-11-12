package com.fds.trabalhofinal.domain.repository;

import com.fds.trabalhofinal.domain.models.ClientModel;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {
    List<ClientModel> findAll();
    Optional<ClientModel> findById(Long id);
    ClientModel save(ClientModel client);
}
