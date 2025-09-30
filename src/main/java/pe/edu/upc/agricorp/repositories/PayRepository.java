package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Pay;

public interface PayRepository extends JpaRepository<Pay, Long> {

}
