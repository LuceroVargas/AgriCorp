package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Cliente_Planta;
import pe.edu.upc.agricorp.repositories.Cliente_PlantaRepo;
import pe.edu.upc.agricorp.services.Cliente_PlantaService;

import java.util.List;

@Service
public class Cliente_PlantaImple implements Cliente_PlantaService {
    @Autowired
    private Cliente_PlantaRepo cliente_PlantaRepo;


    @Override
    public Cliente_Planta addCP(Cliente_Planta cliente_planta) {
        if (cliente_planta.getBirthDate()==null) {
            return null;
        }

        return cliente_PlantaRepo.save(cliente_planta);
    }

    @Override
    public Cliente_Planta editCP(Cliente_Planta cliente_planta) {
        Cliente_Planta clientePlanta = finById(cliente_planta.getId());
        if (clientePlanta==null) {return null;}
        if (clientePlanta.getBirthDate()==null) { return null;}

        return cliente_PlantaRepo.save(clientePlanta);
    }

    @Override
    public void deleteCP(Long id) {
        Cliente_Planta cliente_planta = finById(id);
        if (cliente_planta==null) {return;}

        cliente_PlantaRepo.delete(cliente_planta);
    }

    @Override
    public Cliente_Planta finById(Long id) {
        return cliente_PlantaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente_Planta> findAll() {
        return cliente_PlantaRepo.findAll();
    }
}
