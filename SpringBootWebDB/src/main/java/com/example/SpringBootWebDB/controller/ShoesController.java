package com.example.SpringBootWebDB.controller;

import com.example.SpringBootWebDB.model.Shoes;
import com.example.SpringBootWebDB.model.Shoppers;
import com.example.SpringBootWebDB.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/shoes")
public class ShoesController {
    @Autowired
    private ShoesService service;

    @PostMapping("/add")
    public ResponseEntity<String>
    addProduct(@RequestParam("name") String name,
               @RequestParam("description") String description,
               @RequestParam("price") Float price,
               @RequestParam("image") MultipartFile file) throws
            IOException {
        String response =
                service.addShoe(name, description, price, file);
        return
                ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/addToBasket")
    public Shoes insert(@RequestBody Shoes shoes){
        return service.addShoeToBasket(shoes);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Shoes>> getAllShoes() {
        List<Shoes> shoes = service.getAllshoes();
        return ResponseEntity.status(HttpStatus.OK).body(shoes);
    }

    @GetMapping("/getbyId/{id}")
    public Optional<Shoes> getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id){
        if(service.getById(id).isPresent()) {
            service.deleteById(id);
            return "deleted the shoe " + id;
        }
        else {
            return "shoe is not found";
        }
    }

    @PutMapping("/editShoe")
    public String editShot(@RequestBody Shoes shoe){
        return service.editShoe(shoe);
    }

    @GetMapping("/viewBasket/{id}")
    List<String> viewBasket(@PathVariable Long id) {
        return service.viewBasket(id);
    }
    @GetMapping("/filterByCost/{price}")
    public Object[] findShoesBelowMaxPrice(@PathVariable("price") int price){
        return service.findShoesBelowMaxPrice(price);
    }
}