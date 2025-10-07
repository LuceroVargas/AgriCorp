package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Plant;
import pe.edu.upc.agricorp.repositories.PlantRepository;
import pe.edu.upc.agricorp.services.PlantService;
//import pe.edu.upc.agricorp.services.TaxonomyService;

import java.util.List;


@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    PlantRepository plantRepository;
    //TaxonomyService taxonomyService;


    @Override
    public Plant add(Plant plant) {

        if(plant.getName()==null||plant.getName().isBlank()){
            return null;
        }
        if(plant.getMinimum_space()==null||plant.getMinimum_space()<0||plant.getMinimum_space().toString().isBlank()){
            return null;
        }
        if(plant.getGrowthTime()==null||plant.getGrowthTime()<0||plant.getGrowthTime().toString().isBlank()){
            return null;
        }

        return plantRepository.save(plant);
    }

    @Override
    public Plant edit(Plant plant) {

        Plant plantFound=findById(plant.getId());

        if(plantFound==null){
            return null;
        }

        if(plant.getName()!=null){
            plantFound.setName(plant.getName());
        }

        if(plant.getMinimum_space()!=null){
            plantFound.setMinimum_space(plant.getMinimum_space());
        }

        if(plant.getGrowthTime()!=null){
            plantFound.setGrowthTime(plant.getGrowthTime());
        }

        return plantRepository.save(plantFound);
    }

    @Override
    public void delete(Long id) {
        Plant plantFound=findById(id);
        if(plantFound==null){
            return;
        }
        plantRepository.deleteById(id);
    }

    @Override
    public Plant findById(Long id) {
        return plantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Plant> listAll() {
        return plantRepository.findAll();
    }


    /*@Override
    public PlantDTO findByIdDTO(Long id) {
        Plant plant=plantRepository.findById(id).orElse(null);

        if(plant==null){
            return null;
        }

        return new PlantDTO(
                plant.getId(),
                plant.getName(),
                plant.getMinimum_space(),
                plant.getGrowthTime(),
                plant.getTaxonomy().getId()
        );
    }

    @Override
    public List<PlantReportDTO> reportAll() {
        List<Plant>plants=listAll();

        List<PlantReportDTO> plantReportDTOS=new ArrayList<>();

        for (Plant plant:plants){
            PlantReportDTO plantReportDTO=new PlantReportDTO(plant.getId(), plant.getName(),
                    plant.getMinimum_space(), plant.getGrowthTime(), plant.getTaxonomy().getFamily(),
                    plant.getTaxonomy().getSpecies(), plant.getTaxonomy().getSpecies());

            plantReportDTOS.add(plantReportDTO);
        }

        return plantReportDTOS;


    }

    @Override
    public PlantDTO findPlantWithMinGrowthTime() {
        Plant plant = plantRepository.findPlantWithMinGrowthTime(); // o findTopByOrderByGrowthTimeAsc()
        if (plant == null) return null;

        return new PlantDTO(
                plant.getId(),
                plant.getName(),
                plant.getMinimum_space(),
                plant.getGrowthTime(),
                plant.getTaxonomy().getId()
        );
    }

    */
}
