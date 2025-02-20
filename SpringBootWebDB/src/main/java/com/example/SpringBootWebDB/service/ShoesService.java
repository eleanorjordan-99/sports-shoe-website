package com.example.SpringBootWebDB.service;

import com.example.SpringBootWebDB.model.Shoes;
import com.example.SpringBootWebDB.model.Shoppers;
import com.example.SpringBootWebDB.util.ShoesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ShoesService
{
    private static final String FOLDER_PATH="/Users/jordane/Documents/Java Course/SpringBootWebDB/Images";
    @Autowired
    private ShoesRepo repo;
    public String addShoe(String name, String description, Float price, MultipartFile file) throws IOException {
        File directory=new File(FOLDER_PATH);
        if(!directory.exists()){
                    directory.mkdirs();
            }
            File destinationFile=new
                    File(directory,file.getOriginalFilename());
            file.transferTo(destinationFile);
            Shoes shoe=new Shoes();
            shoe.setName(name);
            shoe.setDescription(description);
            shoe.setPrice(price);
            shoe.setImagepath(file.getOriginalFilename());
            repo.save(shoe);
            return "Shoe uploaded successfully";
            }


    public Shoes addShoeToBasket(Shoes shoes) {
        return repo.save(shoes);
    }

    public Object[] findShoesBelowMaxPrice(int price){
        return repo.findShoesBelowMaxPrice(price);
    }

    public List<Shoes> getAllshoes() {
        return repo.findAll();
    }
    public void deleteById(Long Id) {
        repo.deleteById(Id);
    }
    public Optional<Shoes> getById(Long Id) {
        return repo.findById(Id);
    }
    public List<String> viewBasket(Long id){
        return repo.viewBasket(id);
    }

    public String editShoe(Shoes shoes) {
        if (repo.findById(shoes.getId()).isPresent()) {
            Shoes
                    newshoe = repo.findById(shoes.getId()).orElse(null);
            newshoe.setName(newshoe.getName());
            newshoe.setDescription(newshoe.getDescription());
            newshoe.setPrice(newshoe.getPrice());
            repo.save(shoes);
            return " the shoe is updated";
        }
        else{
            return "Shoe not found to update";
        }
    }
}
