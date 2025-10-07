package pe.edu.upc.agricorp.services;


import pe.edu.upc.agricorp.entities.Plant;

import java.util.List;

public interface PlantService {
    public Plant add(Plant plant);

    public Plant edit(Plant plant);

    public void delete(Long id);

    public Plant findById(Long id);

    public List<Plant> listAll();

    /*public List<PlantReportDTO> reportAll();

    public PlantDTO findPlantWithMinGrowthTime();*/
}
