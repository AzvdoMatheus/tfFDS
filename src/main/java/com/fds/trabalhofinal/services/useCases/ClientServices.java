package com.fds.trabalhofinal.services.useCases;

import com.fds.trabalhofinal.domain.models.ClientModel;
import com.fds.trabalhofinal.domain.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

    private final IClientRepository clientRepository;

    @Autowired
    public ClientServices(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientModel createClient(String clientName, String clientEmail) {
        long clientId = System.currentTimeMillis();
        ClientModel newClient = new ClientModel(clientId, clientName, clientEmail);
        return clientRepository.save(newClient);
    }

    public ClientModel updateClient(Long clientId, String newName, String newEmail) {
        ClientModel client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found."));

        client.setClientName(newName);
        client.setClientEmail(newEmail);

        return clientRepository.save(client);
    }

    public Optional<ClientModel> getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    public List<ClientModel> listAllClients() {
        return clientRepository.findAll();
    }
}
