package pe.edu.upc.agricorp.services;

import pe.edu.upc.agricorp.entities.Recommendation;

import java.util.List;

public interface RecommendationService {

    public Recommendation add(Recommendation recommendation);

    public Recommendation edit(Recommendation recommendation);

    public void delete(Long id);

    public Recommendation findById(Long id);

    public List<Recommendation> listAll();
}
