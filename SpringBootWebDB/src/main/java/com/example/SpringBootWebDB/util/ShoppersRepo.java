package com.example.SpringBootWebDB.util;

import com.example.SpringBootWebDB.model.Shoppers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ShoppersRepo extends JpaRepository<Shoppers,String> {
}