package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Historial;

import java.util.List;

public interface HistorialServi {
    public Historial addH(Historial historial);
    public Historial editH(Historial historial);
    public void deleteH(Long id);
    public List<Historial> findAll();
    public Historial findById(Long id);
}
