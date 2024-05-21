package com.example.locationvoiture1.service;
import com.example.locationvoiture1.dao.entities.Client;
import com.example.locationvoiture1.dao.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientManagerService implements ClientManager {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client saveClient(Client client){return clientRepository.save(client);}
    @Override
    public Client addClient(Client client){
        try{
            return clientRepository.save(client);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    @Override
    public Client updateClient(Client client){
        return null;
    }
    @Override
    public boolean deleteClient(Client client){
        return false;
    }
    @Override
    public boolean deleteClientById(Integer id){
        return false;
    }
    @Override
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    @Override
    public Page<Client> getAllClients(int page, int taille, String keyword) {
        return clientRepository.findByNomContains(keyword, PageRequest.of( page, taille ));
    }
    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    @Override
    public Page<Client> getAllClientByPage(int page, int size) {
        return clientRepository.findAll(PageRequest.of(page, size));
    }
}
