package com.example.SpringBootWebDB.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;
@Entity
public class Shoppers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String pwd;
    private String role;
    private String logged_in;
    @ManyToMany(mappedBy = "shoppers")
    @JsonIgnore
    private Set<Shoes> shoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
            this.role = role;
    }
    public String getLogged_in() {
        return logged_in;
    }

    public void setLogged_in(String logged_in) {
        this.logged_in = logged_in;
    }
    public Set<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(Set<Shoes> shoes) {
        this.shoes = shoes;
    }
}
