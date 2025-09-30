package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.User;
import pe.edu.upc.agricorp.services.UserService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        User newUser = userService.add(user);
        if (newUser==null){
            return new ResponseEntity<>(newUser, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<User> edit(@PathVariable("id") Long id, @RequestBody User user){
        user.setId(id);
        User editedUser= userService.edit(user);
        return new ResponseEntity<>(editedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        User foundUser = userService.findById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listAll(){
        List<User> users = userService.listAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
