package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Role;
import pe.edu.upc.agricorp.services.RoleService;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Role>> listAll(){
        List<Role> roles = roleService.listAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> add(@RequestBody Role role){
        Role newRole = roleService.add(role);
        if (newRole==null){
            return new ResponseEntity<>(newRole, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Role> findById(@PathVariable("id") Long id){
        Role foundRole = roleService.findById(id);
        return new ResponseEntity<>(foundRole, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Role> edit(@PathVariable("id") Long id, @RequestBody Role role){
        role.setId(id);
        Role editedRole = roleService.edit(role);
        return new ResponseEntity<>(editedRole, HttpStatus.OK);
    }
}
