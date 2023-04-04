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

import java.util.Optional;

@Controller
@RequestMapping(path = RESTNamebook.VERSION_1)
public class MainController {
    @Autowired private UserRepository userRepository;
    @Autowired private HomeRepository homeRepository;

    // User - use this to login
    //Get users
    @GetMapping(path = RESTNamebook.USER)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    @GetMapping(path = RESTNamebook.USER + RESTNamebook.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    // Create a user
    @PostMapping(path=RESTNamebook.USER)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user.getName() + " has been saved into database";
    }

    // update a user
    @PutMapping(path = RESTNamebook.USER + RESTNamebook.USER_ID)
    public @ResponseBody String updateUser(@PathVariable Integer id, @RequestParam String name, @RequestParam String email){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
            return user.getName() + " has been updated";
        } else {
            return "User not found";
        }
    }

    // delete a user
    @DeleteMapping(path = RESTNamebook.USER + RESTNamebook.USER_ID)
    public @ResponseBody String deleteUser(@PathVariable Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userRepository.deleteById(id);
            return user.getName() + " has been deleted";
        } else {
            return "User not found";
        }
    }

    // Home
    // Get all homes
    @GetMapping(path = RESTNamebook.USER + RESTNamebook.HOME)
    public @ResponseBody Iterable<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    // Create a home
    @PostMapping(path = RESTNamebook.USER + RESTNamebook.USER_ID + RESTNamebook.HOME)
    public @ResponseBody String addNewHome(
            @PathVariable Integer id,
            @RequestParam int age,
            @RequestParam("dwellingType") String dwellingType,
            @RequestParam("heatingType") String heatingType,
            @RequestParam("location") String location,
            @RequestParam int value){
        Home home = new Home();
        home.setAge(age);
        home.setDwellingType(DwellingType.valueOf(dwellingType));
        home.setHeatingType(HeatingType.valueOf(heatingType));
        home.setLocation(Location.valueOf(location));
        home.setValue(value);

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            home.setUser(user.get());
            homeRepository.save(home);
            return "Saved";
        } else {
            return "Failed";
        }
    }

    // to be continued..
}
