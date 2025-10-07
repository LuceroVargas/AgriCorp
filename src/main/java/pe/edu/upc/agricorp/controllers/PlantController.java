package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Plant;
import pe.edu.upc.agricorp.services.PlantService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    PlantService plantService;

    //Registro de planta
    @PostMapping("/add")
    public ResponseEntity<Plant>add(@RequestBody Plant plant){
        Plant newPlant=plantService.add(plant);

        if(newPlant==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newPlant, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Plant>update(@RequestBody Plant plant, @PathVariable Long id){

        Plant newPlant=plantService.edit(plant);

        if(newPlant==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newPlant, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Plant>getPlant(@PathVariable Long id){
        Plant plant = plantService.findById(id);

        if (plant == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Plant>delete(@PathVariable Long id){
        plantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Plant>>listAll(){
        return new ResponseEntity<>(plantService.listAll(), HttpStatus.OK);
    }


    /*@GetMapping("plants/report")
    public ResponseEntity<List<PlantReportDTO>>reportAll(){
        return new ResponseEntity<>(plantService.reportAll(), HttpStatus.OK);
    }

    @GetMapping("/plants/fastest")
    public ResponseEntity<PlantDTO> getFastestGrowingPlant() {
        PlantDTO dto = plantService.findPlantWithMinGrowthTime();
        if (dto == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }*/


}
