package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Historial;

public interface HistorialRepo extends JpaRepository<Historial,Long> {
}
