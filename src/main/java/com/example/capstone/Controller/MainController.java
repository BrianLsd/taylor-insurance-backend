package com.example.capstone.Controller;

import com.example.capstone.DataAccess.UserRepository;
import com.example.capstone.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = RESTNamebook.VERSION_1)
public class MainController {
    @Autowired private UserRepository userRepository;

    @GetMapping(path = RESTNamebook.USER)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = RESTNamebook.USER + RESTNamebook.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @PostMapping(path=RESTNamebook.USER)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user.getName() + " has been saved into database";
    }
}
