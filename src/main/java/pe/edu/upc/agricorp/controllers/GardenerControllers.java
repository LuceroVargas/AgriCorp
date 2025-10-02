package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Gardener;
import pe.edu.upc.agricorp.serviceimpl.GardenerImple;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/gardeners")
public class GardenerControllers {
    @Autowired
    private GardenerImple gardenerImple;

    @PostMapping("/add")
    public ResponseEntity<Gardener> add(@RequestBody Gardener gardener) {
        Gardener newGardener = gardenerImple.addG(gardener);
        if (newGardener != null) {
            return new ResponseEntity<>(newGardener, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newGardener, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Gardener> delete(@PathVariable("id") Long id) {
        gardenerImple.deleteG(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Gardener> edit(@PathVariable("id") Long id, @RequestBody Gardener gardener) {
        gardener.setId(id);
        Gardener editGardener = gardenerImple.editG(gardener);
        return new ResponseEntity<>(editGardener, HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Gardener>> findAll() {
        List<Gardener> gardeners = gardenerImple.findAll();
        return new ResponseEntity<>(gardeners, HttpStatus.OK);
    }

}
