package pe.edu.upc.agricorp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Taxonomy;
import pe.edu.upc.agricorp.services.TaxonomyService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/DB_PlantStartup")
public class TaxonomyController {

    @Autowired
    TaxonomyService taxonomyService;

    //Registro de taxonomia
    @PostMapping("/taxonomies/insert")
    public ResponseEntity<Taxonomy> add(@RequestBody Taxonomy taxonomy) {
        Taxonomy newTaxonomy = taxonomyService.add(taxonomy);
        if (newTaxonomy == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newTaxonomy, HttpStatus.CREATED);
    }

    //Edicion de taxonomia
    @PutMapping("/taxonomies/{id}")
    public ResponseEntity<Taxonomy> update(@PathVariable Long id, @RequestBody Taxonomy taxonomy) {
        taxonomy.setId(id);

        Taxonomy newTaxonomy = taxonomyService.edit(taxonomy);

        if (newTaxonomy == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newTaxonomy, HttpStatus.OK);

    }

    //Listado de las taxonomias
    @GetMapping("/taxonomies")
    public ResponseEntity<List<Taxonomy>> listAll() {
        return new ResponseEntity<>(taxonomyService.listAll(), HttpStatus.OK);
    }

    //Eliminacion de una taxonomia
    @DeleteMapping("/taxonomies/{id}")
    public ResponseEntity<Taxonomy> delete(@PathVariable Long id) {
        taxonomyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /*listado de las taxonomias con la cantidad de plantas por cada una
    @GetMapping("/taxonomies/reportCount")
    public ResponseEntity<List<TaxonomyReportDTO>> reportPlantsCount() {
        return new ResponseEntity<>(taxonomyService.reportPlantsCount(), HttpStatus.OK);
    }

    @GetMapping("/taxonomies/reportAverage")
    public ResponseEntity<List<TaxonomyGrowthAvgDTO>>reportAverageGrowthTime(){
        return new ResponseEntity<>(taxonomyService.reportPlantsAverageGrowthTime(), HttpStatus.OK);
    }*/

}