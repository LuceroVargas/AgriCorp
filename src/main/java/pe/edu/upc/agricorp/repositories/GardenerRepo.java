package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Gardener;

public interface GardenerRepo extends JpaRepository<Gardener,Long> {
}
