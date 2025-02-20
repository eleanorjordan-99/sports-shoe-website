package com.example.SpringBootWebDB.controller;

import com.example.SpringBootWebDB.model.Shoppers;
import com.example.SpringBootWebDB.service.ShoppersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopper")
public class ShoppersController {
    @Autowired
    ShoppersService service;
    @PostMapping("/insert")
    public Shoppers insert(@RequestBody Shoppers shoppers){
        return service.insertShoppers(shoppers);
    }

    @PostMapping("/insertall")
    public List<Shoppers> insert(@RequestBody List<Shoppers> shoppers){
        return service.insertAll(shoppers);
    }
    @GetMapping("/getbyId/{id}")
    public Optional<Shoppers> getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<Shoppers> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deletebyUsername(@PathVariable("id") String id){
        if(service.getById(id).isPresent()) {
            service.deletebyId(id);
            return "deleted the user " + id;
        }
        else {
            return "user is not found";
        }
    }

    @PutMapping("/updatebyroll")
    public String updateByroll(@RequestBody Shoppers newuserroll){
        return service.updateByroll(newuserroll);
    }

    @PutMapping("/updatebypwd")
    public String updateBypwd(@RequestBody Shoppers newuserpwd){
        return service.updateBypwd(newuserpwd);
    }

    @PutMapping("/login")
    public String logIn(@RequestBody Shoppers logginginuser){
        return service.logIn(logginginuser);
    }
    @PutMapping("/logout")
    public String logOut(@RequestBody Shoppers loggingoutuser){
        return service.logOut(loggingoutuser);
    }
}