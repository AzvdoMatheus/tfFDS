package com.fds.trabalhofinal.controllers;

import com.fds.trabalhofinal.services.useCases.ClientServices;
import com.fds.trabalhofinal.domain.models.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @PostMapping
    public ResponseEntity<ClientModel> createClient(@RequestParam String clientName, @RequestParam String clientEmail) {
        ClientModel client = clientServices.createClient(clientName, clientEmail);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientModel> updateClient(@PathVariable Long id,
                                                    @RequestParam String newName,
                                                    @RequestParam String newEmail) {
        ClientModel updatedClient = clientServices.updateClient(id, newName, newEmail);
        return ResponseEntity.ok(updatedClient);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientModel>> listAllClients() {
        List<ClientModel> clients = clientServices.listAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable Long id) {
        return clientServices.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
