package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Phase;
import pe.edu.upc.agricorp.services.PhaseService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/phases")
public class PhaseController {
    @Autowired
    PhaseService phaseService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Phase>> listAll(){
        List<Phase> phases = phaseService.listAll();
        return new ResponseEntity<>(phases, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Phase> add(@RequestBody Phase phase){
        Phase newPhase = phaseService.add(phase);
        if (newPhase==null){
            return new ResponseEntity<>(newPhase, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newPhase, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Phase> findById(@PathVariable("id") Long id){
        Phase foundPhase = phaseService.findById(id);
        return new ResponseEntity<>(foundPhase, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        phaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Phase> edit(@PathVariable("id") Long id, @RequestBody Phase phase){
        phase.setId(id);
        Phase editedPhase = phaseService.edit(phase);
        return new ResponseEntity<>(editedPhase, HttpStatus.OK);
    }

}
