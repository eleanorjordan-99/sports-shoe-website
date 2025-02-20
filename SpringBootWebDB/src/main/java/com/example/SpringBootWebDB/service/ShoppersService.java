package com.example.SpringBootWebDB.service;

import com.example.SpringBootWebDB.model.Shoppers;
import com.example.SpringBootWebDB.util.ShoppersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppersService {
    @Autowired
    ShoppersRepo repo;

    public Shoppers insertShoppers(Shoppers shoppers) {
        return repo.save(shoppers);
    }

    public List<Shoppers> insertAll(List<Shoppers> shoppers) {
        return repo.saveAll(shoppers);
    }

    public List<Shoppers> getAll() {
        return repo.findAll();
    }

    public Optional<Shoppers> getById(String id) {
        return repo.findById(id);
    }
    public void deletebyId(String id){
        repo.deleteById(id);
    }

    public String updateByroll(Shoppers newuserroll) {
        if (repo.findById(newuserroll.getId().toString()).isPresent()) {
            Shoppers
                    olddbuser = repo.findById(newuserroll.getId().toString()).orElse(null);
                    olddbuser.setRole(newuserroll.getRole());
            repo.save(olddbuser);
            return " the User role is updated";
        }
        else{
            return "User not found to update";
        }
    }

    public String updateBypwd(Shoppers newuserpwd) {
        if (repo.findById(newuserpwd.getId().toString()).isPresent()) {
            Shoppers
                    olddbuser = repo.findById(newuserpwd.getId().toString()).orElse(null);
            olddbuser.setPwd(newuserpwd.getPwd());
            repo.save(olddbuser);
            return " the User password is updated";
        }
        else{
            return "User not found to update";
        }
    }

    public String logIn(Shoppers enteredpwd) {
        if (repo.findById(enteredpwd.getId().toString()).isPresent()) {
            if (enteredpwd.getPwd().equals(repo.findById(enteredpwd.getId().toString()).get().getPwd())) {
                Shoppers
                        loggedinuser = repo.findById(enteredpwd.getId().toString()).orElse(null);
                loggedinuser.setLogged_in("TRUE");
                repo.save(loggedinuser);
                return "The User is logged in";
            } else {
                return "Incorrect password, please try again or reach out to admin for support";
            }
        }
        else {
            return "Username not found to login";
        }
    }

    public String logOut(Shoppers enteredusername) {
        if (repo.findById(enteredusername.getId().toString()).isPresent()) {
                Shoppers
                        loggedinuser = repo.findById(enteredusername.getId().toString()).orElse(null);
                loggedinuser.setLogged_in("FALSE");
                repo.save(loggedinuser);
                return "The User has logged out";
            }
        else {
            return "Username not found to logout";
        }
    }
}
