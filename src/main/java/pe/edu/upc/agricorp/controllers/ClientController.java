package pe.edu.upc.agricorp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Client;
import pe.edu.upc.agricorp.services.ClientService;


import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Client>> listAll(){
        List<Client> clients = clientService.listAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> add(@RequestBody Client client){
        Client newClient = clientService.add(client);
        if (newClient==null){
            return new ResponseEntity<>(newClient, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id){
        Client foundClient = clientService.findById(id);
        return new ResponseEntity<>(foundClient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Client> edit(@PathVariable("id") Long id, @RequestBody Client client){
        client.setId(id);
        Client editedClient = clientService.edit(client);
        return new ResponseEntity<>(editedClient, HttpStatus.OK);
    }

}
