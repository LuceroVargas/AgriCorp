package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Gardener;

import java.util.List;

public interface GardenerService {
    public Gardener addG(Gardener gardener);
    public Gardener editG(Gardener gardener);
    public void deleteG(Long id);
    public List<Gardener> findAll();
    public Gardener findGById(Long id);
}
