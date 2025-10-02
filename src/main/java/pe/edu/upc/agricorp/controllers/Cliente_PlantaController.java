package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Cliente_Planta;
import pe.edu.upc.agricorp.serviceimpl.Cliente_PlantaImple;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/clientplantas")
public class Cliente_PlantaController {
    @Autowired
    private Cliente_PlantaImple cliente_plantaImple;

    @PostMapping("/add")
    public ResponseEntity<Cliente_Planta> addCP(@RequestBody Cliente_Planta cliente_Planta) {
        Cliente_Planta newCliente_Planta = cliente_plantaImple.addCP(cliente_Planta);
        if (newCliente_Planta != null) {
            return new ResponseEntity<>(newCliente_Planta, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newCliente_Planta, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCP(@PathVariable("id") Long id) {
        cliente_plantaImple.deleteCP(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Cliente_Planta> edit(@PathVariable("id") Long id, @RequestBody Cliente_Planta cliente_Planta) {
        cliente_Planta.setId(id);
        Cliente_Planta editCP = cliente_plantaImple.editCP(cliente_Planta);
        return new ResponseEntity<>(editCP, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Cliente_Planta> findById(@PathVariable("id") Long id) {
        Cliente_Planta foundCP = cliente_plantaImple.finById(id);
        return new ResponseEntity<>(foundCP, HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente_Planta>> findAll() {
        List<Cliente_Planta> foundCP = cliente_plantaImple.findAll();
        return new ResponseEntity<>(foundCP, HttpStatus.OK);
    }
}
