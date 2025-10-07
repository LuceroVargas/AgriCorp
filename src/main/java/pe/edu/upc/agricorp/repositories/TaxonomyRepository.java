package pe.edu.upc.agricorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.agricorp.entities.Taxonomy;

import java.util.List;

public interface TaxonomyRepository extends JpaRepository<Taxonomy, Long> {


    List<Taxonomy> findBySpecies(String species);
    List<Taxonomy> findByFamily(String family);

    /*@Query("SELECT new pe.edu.upc.agricorp.DTOs.TaxonomyGrowthAvgDTO(t.id, t.family, t.species, " +
            "AVG(p.growthTime)) FROM Plant p INNER JOIN p.taxonomy t GROUP BY t.id, t.family, t.species" +
            " ORDER BY t.id" )
    List<TaxonomyGrowthAvgDTO> averageGrowthTime();*/




}
