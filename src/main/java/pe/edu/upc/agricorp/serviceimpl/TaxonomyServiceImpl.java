package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Taxonomy;
import pe.edu.upc.agricorp.repositories.TaxonomyRepository;
import pe.edu.upc.agricorp.services.TaxonomyService;

import java.util.List;

@Service
public class TaxonomyServiceImpl implements TaxonomyService {

    @Autowired
    TaxonomyRepository taxonomyRepository;

    public boolean validarEntidad(Taxonomy taxonomy){
        if (taxonomy.getFamily()==null||taxonomy.getFamily().isBlank()){
            return false;
        }
        if (taxonomy.getSpecies()==null||taxonomy.getSpecies().isBlank()){
            return false;
        }
        if (taxonomy.getCommonName()==null||taxonomy.getCommonName().isBlank()){
            return false;
        }
        if (taxonomy.getDescription()==null||taxonomy.getDescription().isBlank()){
            return false;
        }
        return true;
    }

    @Override
    public Taxonomy add(Taxonomy taxonomy) {

        if(!validarEntidad(taxonomy)){
            return null;
        }
        //validar si tanto la familia como especies ya se encuentran registrados
        if(!(taxonomyRepository.findBySpecies(taxonomy.getSpecies()).isEmpty()
        ||taxonomyRepository.findByFamily(taxonomy.getFamily()).isEmpty())){
            return null;
        }
        return taxonomyRepository.save(taxonomy);

    }

    @Override
    public Taxonomy edit(Taxonomy taxonomy) {

        Taxonomy taxonomyFound=findById(taxonomy.getId());
        if(taxonomyFound==null){
            return null;
        }
        if(taxonomy.getFamily()!=null){
            taxonomyFound.setFamily(taxonomy.getFamily());
        }
        if(taxonomy.getSpecies()!=null){
            taxonomyFound.setSpecies(taxonomy.getSpecies());
        }
        if(taxonomy.getDescription()!=null){
            taxonomyFound.setDescription(taxonomy.getDescription());
        }
        if(taxonomy.getCommonName()!=null){
            taxonomyFound.setCommonName(taxonomy.getCommonName());
        }

        if(!validarEntidad((taxonomyFound))){
            return null;
        }

        return taxonomyRepository.save(taxonomyFound);
    }

    @Override
    public void delete(Long id) {

        Taxonomy taxonomyFound=findById(id);

        if(taxonomyFound==null){
            return;
        }
        if(!taxonomyFound.getPlants().isEmpty()){
            return;
        }

        taxonomyRepository.deleteById(id);
    }

    @Override
    public Taxonomy findById(Long id) {
        return taxonomyRepository.findById(id).orElse(null);
    }


    @Override
    public List<Taxonomy> listAll() {
        return taxonomyRepository.findAll();
    }

    /*@Override
    public List<TaxonomyReportDTO> reportPlantsCount() {
        List<Taxonomy> taxonomies=listAll();
        List<TaxonomyReportDTO> taxonomyReportDTOS=new ArrayList<>();

        for (Taxonomy taxonomy:taxonomies){

            TaxonomyReportDTO taxonomyReportDTO=new TaxonomyReportDTO(
                    taxonomy.getId(), taxonomy.getFamily(), taxonomy.getPlants().size()
            );
            taxonomyReportDTOS.add(taxonomyReportDTO);
        }
        return taxonomyReportDTOS;
    }

    public List<TaxonomyGrowthAvgDTO> reportPlantsAverageGrowthTime(){
        return taxonomyRepository.averageGrowthTime();
    }*/

}

