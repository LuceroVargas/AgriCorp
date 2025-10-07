package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Client;
import pe.edu.upc.agricorp.repositories.ClientRepository;
import pe.edu.upc.agricorp.services.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;


    @Override
    public Client add(Client client) {

        if (client.getName()==null || client.getName().isBlank()) {
            return null;
        }
        if (client.getLastName()==null || client.getLastName().isBlank()) {
            return null;
        }
        if (client.getPhoneNumber()==null || client.getPhoneNumber().isBlank() || !client.getPhoneNumber().matches("\\d{9}")){
            return null;
        }
        if (client.getLocation()==null || client.getLocation().isBlank()) {
            return null;
        }


        return clientRepository.save(client);
    }

    @Override
    public Client edit(Client client) {
        Client clientFound = findById(client.getId());
        if (clientFound==null){
            return null;
        }
        if (client.getName()!=null) {
            clientFound.setName(client.getName());
        }
        if (client.getLastName()!=null) {
            clientFound.setLastName(client.getLastName());
        }
        if (client.getPhoneNumber()!=null) {
            clientFound.setPhoneNumber(client.getPhoneNumber());
        }
        if (client.getLocation()!=null) {
            clientFound.setLocation(client.getLocation());
        }


        return clientRepository.save(clientFound);
    }

    @Override
    public void delete(Long id) {

        Client clientFound = findById(id);
        if (clientFound==null){
            return;
        }

        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> listAll() {
        return clientRepository.findAll();
    }



}
