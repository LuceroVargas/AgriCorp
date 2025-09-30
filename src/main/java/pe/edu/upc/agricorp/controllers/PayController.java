package pe.edu.upc.agricorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.agricorp.entities.Pay;
import pe.edu.upc.agricorp.services.PayService;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/pays")
public class PayController {

    @Autowired
    PayService payService;

    @PostMapping("/add")
    public ResponseEntity<Pay> add(@RequestBody Pay pay){
        Pay newPay = payService.add(pay);
        if (newPay==null){
            return new ResponseEntity<>(newPay, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newPay, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Pay> edit(@PathVariable("id") Long id, @RequestBody Pay pay){
        pay.setId(id);
        Pay editedPay = payService.edit(pay);
        return new ResponseEntity<>(editedPay, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        payService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Pay> findById(@PathVariable("id") Long id){
        Pay foundPay = payService.findById(id);
        return new ResponseEntity<>(foundPay, HttpStatus.OK);
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<Pay>> listAll(){
        List<Pay> pays = payService.listAll();
        return new ResponseEntity<>(pays, HttpStatus.OK);
    }
}
