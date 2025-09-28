package pe.edu.upc.agricorp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.agricorp.entities.Recommendation;
import pe.edu.upc.agricorp.repositories.RecommendationRepository;
import pe.edu.upc.agricorp.services.RecommendationService;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    RecommendationRepository recommendationRepository;


    @Override
    public Recommendation add(Recommendation recommendation) {

        if (recommendation.getType()==null || recommendation.getType().isBlank()) {
            return null;
        }

        if (recommendation.getMessage()==null || recommendation.getMessage().isBlank()) {
            return null;
        }

        return recommendationRepository.save(recommendation);
    }

    @Override
    public Recommendation edit(Recommendation recommendation) {
        Recommendation recommendationFound = findById(recommendation.getId());
        if (recommendationFound==null){
            return null;
        }
        if (recommendation.getType()!=null) {
            recommendationFound.setType(recommendation.getType());
        }
        if (recommendation.getMessage()!=null) {
            recommendationFound.setMessage(recommendation.getMessage());
        }

        return recommendationRepository.save(recommendationFound);
    }

    @Override
    public void delete(Long id) {

        Recommendation recommendationFound = findById(id);
        if (recommendationFound==null){
            return;
        }

        recommendationRepository.deleteById(id);
    }

    @Override
    public Recommendation findById(Long id) {
        return recommendationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Recommendation> listAll() {
        return recommendationRepository.findAll();
    }
}
