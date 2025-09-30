package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
