package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Recommendation;
import pe.edu.upc.agricorp.services.RecommendationService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Recommendation>> listAll(){
        List<Recommendation> recommendations = recommendationService.listAll();
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Recommendation> add(@RequestBody Recommendation recommendation){
        Recommendation newRecommendation = recommendationService.add(recommendation);
        if (newRecommendation==null){
            return new ResponseEntity<>(newRecommendation, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newRecommendation, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Recommendation> findById(@PathVariable("id") Long id){
        Recommendation foundRecommendation = recommendationService.findById(id);
        return new ResponseEntity<>(foundRecommendation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        recommendationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Recommendation> edit(@PathVariable("id") Long id, @RequestBody Recommendation recommendation){
        recommendation.setId(id);
        Recommendation editedRecommendation = recommendationService.edit(recommendation);
        return new ResponseEntity<>(editedRecommendation, HttpStatus.OK);
    }
}
