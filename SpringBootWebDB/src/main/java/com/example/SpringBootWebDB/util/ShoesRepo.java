package com.example.SpringBootWebDB.util;

import com.example.SpringBootWebDB.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoesRepo extends JpaRepository<Shoes,Long> {
    String sql1="select sh.name, sh.description, sh.price from Shoes sh JOIN sh.shoppers s where s.id=:id";
    @Query(sql1)
    List<String> viewBasket(@Param("id")  Long id);

    String sql2="select sh.id, sh.name, sh.description, sh.price, sh.imagepath from Shoes sh where sh.price<=?1";
    @Query(sql2)
    public Object [] findShoesBelowMaxPrice(int price);
}