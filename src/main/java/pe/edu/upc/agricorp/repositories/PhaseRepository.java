package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Phase;

public interface PhaseRepository extends JpaRepository<Phase, Long> {
}
