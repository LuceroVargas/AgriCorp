package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
