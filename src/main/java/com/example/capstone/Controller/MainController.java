package com.example.capstone.Controller;

import com.example.capstone.DataAccess.AutoRepository;
import com.example.capstone.DataAccess.HomeRepository;
import com.example.capstone.DataAccess.UserRepository;
import com.example.capstone.POJOS.*;
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
    @Autowired private AutoRepository autoRepository;

    // User - use this to login

    /**
     * Get Mapping for User
     * @return all users
     */
    @GetMapping(path = RESTNamebook.USERS)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get Mapping for User based on ID
     * @param user_id user id
     * @return user object
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer user_id){
        return userRepository.findById(user_id);
    }

    /**
     * Post Mapping for User - create user
     * @param name name of user
     * @param email email of user
     * @return message stating success / failure
     */
    @PostMapping(path=RESTNamebook.USERS)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user.getName() + " has been saved into the database.";
    }

    /**
     * Put Mapping for User based on ID - update user
     * @param user_id user id
     * @param name name of user
     * @param email email of user
     * @return message stating success / failure
     */
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

    /**
     * Delete Mapping for User based on ID
     * @param user_id user id
     * @return message stating success / failure
     */
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

    /**
     * Get Mapping for Home
     * @return all homes
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.HOMES)
    public @ResponseBody Iterable<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    /**
     * Get Mapping for Home based on ID
     * @param user_id user id
     * @return home object
     */
    @GetMapping(path=RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES)
    public @ResponseBody Iterable<Home> getAllHomesByUser(@PathVariable(name = "user_id") Integer user_id){
        Optional<User> user = userRepository.findById(user_id);
        Iterable<Home> homes = new LinkedList<>();

        if(user.isPresent()){
            homes = homeRepository.getAllByUserId(user.get().getId());
        }
        return homes;
    }

    /**
     * Get Mapping for Home based on ID
     * @param user_id user id
     * @param dateBuilt date built
     * @param value value
     * @param dwellingType dwelling type
     * @param heatingType heating type
     * @param location location
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES)
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

    /**
     * Put Mapping for Home based on ID - update home
     * @param user_id user id
     * @param home_id home id
     * @param dateBuilt date built
     * @param value value
     * @param dwellingType dwelling type
     * @param heatingType  heating type
     * @param location location
     */
    @PutMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES + "/{home_id}")
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

    /**
     * Delete Mapping for Home based on ID
     * @param user_id user id
     * @param home_id home id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES + "/{home_id}")
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

    // Auto
    /**
     * Get all autos
     * @return Iterable of all autos
     */
    @GetMapping(path=RESTNamebook.USERS + RESTNamebook.AUTOS)
    public @ResponseBody Iterable<Vehicle> getAllAutos(){
        return autoRepository.findAll();
    }

    /**
     * Get all autos by user
     * @param user_id user id
     * @return Iterable of all autos by user
     */
    @GetMapping(path = RESTNamebook.USERS +"/{user_id}" + RESTNamebook.AUTOS)
    public @ResponseBody Iterable<Vehicle> getAllAutosByUser(@PathVariable(name = "user_id") Integer user_id){
        Optional<User> user = userRepository.findById(user_id);
        Iterable<Vehicle> autos = new LinkedList<>();

        if(user.isPresent()){
            autos = autoRepository.getAllByUserId(user.get().getId());
        }
        return autos;
    }

    /**
     * Get auto by id
     * @param user_id user id
     * @param year year
     * @param model model
     * @param make make
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOS)
    public @ResponseBody String addNewAuto(@PathVariable(name = "user_id") Integer user_id,
                                           @RequestParam int year,
                                           @RequestParam String model,
                                           @RequestParam String make) {
        Vehicle vehicle = new Vehicle();
        vehicle.setYear(year);
        vehicle.setModel(model);
        vehicle.setMake(make);

        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            vehicle.setUser(optionalUser.get());
            autoRepository.save(vehicle);
            return "The auto has been saved into the database.";
        } else {
            return "The auto failed to be saved into the database.";
        }
    }

    /**
     * Delete Mapping for Auto based on ID
     * @param user_id user id
     * @param auto_id auto id
     * @return message stating success / failure
     */
    @PutMapping (path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOS + "/{auto_id}")
    public @ResponseBody String updateAuto(@PathVariable(name = "user_id") Integer user_id,
                                           @PathVariable(name = "auto_id") Integer auto_id,
                                           @RequestParam int year,
                                           @RequestParam String model,
                                           @RequestParam String make) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            Optional<Vehicle> optionalAuto = autoRepository.findById(auto_id);
            if (optionalAuto.isPresent()){
                Vehicle vehicle = optionalAuto.get();
                vehicle.setYear(year);
                vehicle.setModel(model);
                vehicle.setMake(make);
                autoRepository.save(vehicle);
                return "The auto has been updated in the database.";
            } else {
                return "Auto not found.";
            }
        } else {
            return "User not found.";
        }
    }

    /**
     * Delete Mapping for Auto based on ID
     * @param user_id user id
     * @param auto_id auto id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOS + "/{auto_id}")
    public @ResponseBody String deleteAuto(@PathVariable Integer user_id,
                                           @PathVariable Integer auto_id){
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()){
            Optional<Vehicle> optionalAuto = autoRepository.findById(auto_id);
            if (optionalAuto.isPresent()){
                autoRepository.deleteById(auto_id);
                return "The auto has been deleted from the database.";
            } else {
                return "Auto not found.";
            }
        } else {
            return "User not found.";
        }
    }
}
