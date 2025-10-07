package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Plant;


public interface PlantRepository extends JpaRepository<Plant, Long> {

    /*@Query(value = "SELECT * FROM plants WHERE id_Taxonomy=?1", nativeQuery = true)
    public List<Plant>findByTaxonomyIdSQL(Long id);

    @Query(value = "SELECT * FROM plants ORDER BY growth_time ASC LIMIT 1", nativeQuery = true)
    public Plant findPlantWithMinGrowthTime();*/

}
