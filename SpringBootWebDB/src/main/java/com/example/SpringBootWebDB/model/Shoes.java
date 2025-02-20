package com.example.SpringBootWebDB.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;
@Entity
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Float price;
    private String imagepath;
    @ManyToMany
    @JoinTable(
            name = "user_shopping_cart",
            joinColumns = @JoinColumn(name="shoe_id"),
            inverseJoinColumns = @JoinColumn(name="shopper_id")
    )
//    @JsonIgnore
    private Set<Shoppers> shoppers;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    public Set<Shoppers> getShoppers() {
        return shoppers;
    }
    public void setShoppers(Set<Shoppers> shoppers) {
        this.shoppers = shoppers;
    }
}
