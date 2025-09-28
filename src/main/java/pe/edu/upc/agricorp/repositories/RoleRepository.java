package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
