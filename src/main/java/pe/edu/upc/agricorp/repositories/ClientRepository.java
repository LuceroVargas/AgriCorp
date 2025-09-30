package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
