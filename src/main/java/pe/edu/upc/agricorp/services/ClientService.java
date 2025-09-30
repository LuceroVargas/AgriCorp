package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Client;

import java.util.List;

public interface ClientService {
    public Client add(Client client);

    public Client edit(Client client);

    public void delete(Long id);

    public Client findById(Long id);

    public List<Client> listAll();
}
