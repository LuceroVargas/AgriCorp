package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Phase;

import java.util.List;

public interface PhaseService {
    public Phase add(Phase phase);

    public Phase edit(Phase phase);

    public void delete(Long id);

    public Phase findById(Long id);

    public List<Phase> listAll();
}
