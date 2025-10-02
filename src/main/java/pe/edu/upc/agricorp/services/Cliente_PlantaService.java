package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Cliente_Planta;

import java.util.List;

public interface Cliente_PlantaService {
    public Cliente_Planta addCP(Cliente_Planta cliente_planta);
    public Cliente_Planta editCP(Cliente_Planta cliente_planta);
    public void deleteCP(Long id);
    public Cliente_Planta finById(Long id);
    public List<Cliente_Planta> findAll();
}
