package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Historial;
import pe.edu.upc.agricorp.repositories.HistorialRepo;
import pe.edu.upc.agricorp.services.HistorialServi;

import java.util.List;

@Service

public class Historialmple implements HistorialServi {
    @Autowired
    private HistorialRepo historialRepo;

    @Override
    public Historial addH(Historial historial) {
        if (historial.getDate() == null) {
            return null;
        }
        if (historial.getObservation() == null || historial.getObservation().isBlank()) {
            return null;
        }
        if (historial.getImage() == null) {
            return null;
        }
        return historialRepo.save(historial);
    }

    @Override
    public Historial editH(Historial historial) {
        Historial historial1 = findById(historial.getId());
        if (historial1 == null) {
            return null;
        }
        if (historial1.getObservation() == null) {
            return null;
        }
        if (historial1.getImage() == null) {
            return null;
        }
        return historialRepo.save(historial);
    }

    @Override
    public void deleteH(Long id) {
        Historial historial = findById(id);
        if (historial == null) {
            return;
        }
        historialRepo.delete(historial);
    }

    @Override
    public List<Historial> findAll() {
        return historialRepo.findAll();
    }

    @Override
    public Historial findById(Long id) {
        return historialRepo.findById(id).orElse(null);
    }
}
