package com.fds.trabalhofinal.persistence.itfImpl;

import com.fds.trabalhofinal.domain.models.ClientModel;
import com.fds.trabalhofinal.domain.repository.IClientRepository;
import com.fds.trabalhofinal.persistence.Client;
import com.fds.trabalhofinal.persistence.repositories.IClient_Rep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IClient_JPA implements IClientRepository {
    private final IClient_Rep clientRep;

    public IClient_JPA(IClient_Rep clientRep) {
        this.clientRep = clientRep;
    }

    @Override
    public List<ClientModel> findAll() {
        return StreamSupport.stream(clientRep.findAll().spliterator(), false)
                .map(Client::toClientModel)
                .collect(Collectors.toList());
    }

    @Override
    public ClientModel save(ClientModel client) {
        Client savedClient = clientRep.save(Client.fromClientModel(client));
        return Client.toClientModel(savedClient);
    }

    @Override
    public Optional<ClientModel> findById(Long id) {
        return clientRep.findById(id).map(Client::toClientModel);
    }
}
