package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Chat;

public interface ChatRepo extends JpaRepository<Chat,Long> {
}
