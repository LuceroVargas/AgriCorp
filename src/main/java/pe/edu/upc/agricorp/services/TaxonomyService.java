package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Taxonomy;

import java.util.List;

public interface TaxonomyService {

    public Taxonomy add(Taxonomy taxonomy);

    public Taxonomy edit(Taxonomy taxonomy);


    public void delete(Long id);

    public Taxonomy findById(Long id);

    public List<Taxonomy> listAll();

    /*public List<TaxonomyReportDTO> reportPlantsCount();

    public List<TaxonomyGrowthAvgDTO>reportPlantsAverageGrowthTime();*/


}
