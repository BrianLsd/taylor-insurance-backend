package com.example.capstone.Controller;

import com.example.capstone.DataAccess.HomeRepository;
import com.example.capstone.DataAccess.UserRepository;
import com.example.capstone.POJOS.DwellingType;
import com.example.capstone.POJOS.HeatingType;
import com.example.capstone.POJOS.Home;
import com.example.capstone.POJOS.Location;
import com.example.capstone.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;

@Controller
@RequestMapping(path = RESTNamebook.VERSION_1)
public class MainController {
    @Autowired private UserRepository userRepository;
    @Autowired private HomeRepository homeRepository;

    // User - use this to login

    // get all users
    @GetMapping(path = RESTNamebook.USERS)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by ID
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer user_id){
        return userRepository.findById(user_id);
    }

    // create a user
    @PostMapping(path=RESTNamebook.USERS)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user.getName() + " has been saved into the database.";
    }

    // update a user
    @PutMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID)
    public @ResponseBody String updateUser(@PathVariable Integer user_id, @RequestParam String name, @RequestParam String email){
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
            return user.getName() + " has been updated in the database.";
        } else {
            return "User not found.";
        }
    }

    // delete a user
    @DeleteMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID)
    public @ResponseBody String deleteUser(@PathVariable Integer user_id){
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userRepository.deleteById(user_id);
            return user.getName() + " has been deleted from the database.";
        } else {
            return "User not found.";
        }
    }

    // Home

    // get all homes
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.HOMES)
    public @ResponseBody Iterable<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    // get all homes for a user
    @GetMapping(path=RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES)
    public @ResponseBody Iterable<Home> getAllHomesByUser(@PathVariable(name = "user_id") Integer user_id){
        Optional<User> user = userRepository.findById(user_id);
        Iterable<Home> homes = new LinkedList<>();  //Hack to build an empty list / iterable

        if(user.isPresent()){
            homes = homeRepository.getAllByUserId(user.get().getId());
        }
        return homes;
    }

    // create a home for a user
    @PostMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID + RESTNamebook.HOMES)
    public @ResponseBody String addNewHome(
            @PathVariable(name = "user_id") Integer user_id,
            @RequestParam LocalDate dateBuilt,
            @RequestParam double value,
            @RequestParam("dwellingType") String dwellingType,
            @RequestParam("heatingType") String heatingType,
            @RequestParam("location") String location){
        Home home = new Home();
        home.setDateBuilt(dateBuilt);
        home.setValue(value);
        home.setDwellingType(DwellingType.valueOf(dwellingType));
        home.setHeatingType(HeatingType.valueOf(heatingType));
        home.setLocation(Location.valueOf(location));

        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            home.setUser(optionalUser.get());
            homeRepository.save(home);
            return "The home has been saved into the database.";
        } else {
            return "The home failed to be saved into the database.";
        }
    }

    // update a home for a user
    @PutMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID + RESTNamebook.HOMES + RESTNamebook.HOME_ID)
    public @ResponseBody String updateHome(@PathVariable Integer user_id, @PathVariable Integer home_id,
                                           @RequestParam LocalDate dateBuilt,
                                           @RequestParam double value,
                                           @RequestParam("dwellingType") String dwellingType,
                                           @RequestParam("heatingType") String heatingType,
                                           @RequestParam("location") String location){

        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            Optional<Home> optionalHome = homeRepository.findById(home_id);
            if (optionalHome.isPresent()){
                Home home = optionalHome.get();
                home.setDateBuilt(dateBuilt);
                home.setValue(value);
                home.setDwellingType(DwellingType.valueOf(dwellingType));
                home.setHeatingType(HeatingType.valueOf(heatingType));
                home.setLocation(Location.valueOf(location));
                homeRepository.save(home);
                return "The home has been updated in the database.";
            } else {
                return "Home not found.";
            }
        } else {
            return "User not found.";
        }
    }

    // delete a home for a user
    @DeleteMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID + RESTNamebook.HOMES + RESTNamebook.HOME_ID)
    public @ResponseBody String deleteHome(@PathVariable Integer user_id, @PathVariable Integer home_id){
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            Optional<Home> optionalHome = homeRepository.findById(home_id);
            if (optionalHome.isPresent()){
                homeRepository.deleteById(home_id);
                return "The home has been deleted from the database.";
            } else {
                return "Home not found.";
            }
        } else {
            return "User not found.";
        }
    }
}
