package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Historial;
import pe.edu.upc.agricorp.serviceimpl.Historialmple;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/historials")

public class HistorialContro {
    @Autowired
    Historialmple historiaImple;

    @PostMapping("/add")
    public ResponseEntity<Historial> addHistorial(@RequestBody Historial historial) {
        Historial historial1 = historiaImple.addH(historial);
        if (historial1 != null) {
            return new ResponseEntity<>(historial1, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(historial, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Historial> deleteHistorial(@PathVariable("id") Long id) {
        historiaImple.deleteH(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Historial> editHistorial(@PathVariable("id") Long id, @RequestBody Historial historial) {
        historial.setId(id);
        Historial historial1 = historiaImple.editH(historial);
        return new ResponseEntity<>(historial1, HttpStatus.OK);
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Historial> findById(@PathVariable("id") Long id) {
        Historial historial = historiaImple.findById(id);
        return new ResponseEntity<>(historial, HttpStatus.OK);
    }
    @GetMapping("/listall")
    public ResponseEntity<List<Historial>> findAllHistorial() {
        List<Historial> historials = historiaImple.findAll();
        return new ResponseEntity<>(historials, HttpStatus.OK);
    }
}
