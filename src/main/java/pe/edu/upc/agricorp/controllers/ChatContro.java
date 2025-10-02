package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Chat;
import pe.edu.upc.agricorp.serviceimpl.ChatImple;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/chats")

public class ChatContro {
    @Autowired
    private ChatImple chatImple;

    @PostMapping("/add")
    public ResponseEntity<Chat> addChat(@RequestBody Chat chat) {
        Chat chat1 = chatImple.addC(chat);
        if (chat1 != null) {
            return new ResponseEntity<>(chat1, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(chat, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Chat> deleteChat(@PathVariable("id") Long id) {
        chatImple.deleteC(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Chat> editChat(@PathVariable("id") Long id, @RequestBody Chat chat) {
       chat.setId(id);
       Chat chat1 = chatImple.editC(chat);
       return new ResponseEntity<>(chat1, HttpStatus.OK);
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Chat> findById(@PathVariable("id") Long id) {
        Chat chat = chatImple.findById(id);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }
    @GetMapping("/listall")
    public ResponseEntity<List<Chat>> findAllChat() {
        List<Chat> chats = chatImple.findAll();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }
}
