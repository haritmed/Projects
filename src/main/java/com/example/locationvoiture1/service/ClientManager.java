package com.example.locationvoiture1.service;
import com.example.locationvoiture1.dao.entities.Client;
import com.example.locationvoiture1.dao.entities.Voiture;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientManager {
    public Client saveClient(Client client);
    public Client addClient(Client client);
    public Client updateClient(Client client);
    public boolean deleteClient(Client client);
    public boolean deleteClientById(Integer id);
    public List<Client> getAllClients();
    public Client getClientById(Long id);
    Page<Client> getAllClientByPage(int page, int size);
    public  Page<Client> getAllClients(int page, int taille, String keyword);
}
