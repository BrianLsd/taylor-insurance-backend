package com.example.capstone.Controller;

import com.example.capstone.DataAccess.*;
import com.example.capstone.POJOS.*;
import com.example.capstone.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping(path = RESTNamebook.VERSION_1)
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private HomeownerRepository homeownerRepository;
    @Autowired
    private AutoQuoteRepository autoQuoteRepository;
    @Autowired
    private HomeQuoteRepository homeQuoteRepository;
    @Autowired
    private AutoPolicyRepository autoPolicyRepository;
    @Autowired
    private HomePolicyRepository homePolicyRepository;

    // User - use this to login

    /**
     * Get Mapping for User
     *
     * @return all users
     */
    @GetMapping(path = RESTNamebook.USERS)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get Mapping for User based on ID
     *
     * @param user_id user id
     * @return user object
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer user_id) {
        return userRepository.findById(user_id);
    }

    /**
     * Post Mapping for User - create user
     *
     * @param name  name of user
     * @param email email of user
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user.getName() + " has been saved into the database.";
    }

    /**
     * Put Mapping for User based on ID - update user
     *
     * @param user_id user id
     * @param name    name of user
     * @param email   email of user
     * @return message stating success / failure
     */
    @PutMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID)
    public @ResponseBody String updateUser(@PathVariable Integer user_id, @RequestParam String name, @RequestParam String email) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
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
     *
     * @param user_id user id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + RESTNamebook.USER_ID)
    public @ResponseBody String deleteUser(@PathVariable Integer user_id) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
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
     *
     * @return all homes
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.HOMES)
    public @ResponseBody Iterable<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    /**
     * Get Mapping for Home based on ID
     *
     * @param user_id user id
     * @return home object
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES)
    public @ResponseBody Iterable<Home> getAllHomesByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<Home> homes = new LinkedList<>();

        if (user.isPresent()) {
            homes = homeRepository.getAllByUserId(user.get().getId());
        }
        return homes;
    }

    /**
     * Post Mapping for Home - create home
     *
     * @param user_id      user id
     * @param dateBuilt    date built
     * @param value        value
     * @param dwellingType dwelling type
     * @param heatingType  heating type
     * @param location     location
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES)
    public @ResponseBody String addNewHome(
            @PathVariable(name = "user_id") Integer user_id,
            @RequestParam LocalDate dateBuilt,
            @RequestParam double value,
            @RequestParam("dwellingType") String dwellingType,
            @RequestParam("heatingType") String heatingType,
            @RequestParam("location") String location) {
        Home home = new Home();
        home.setDateBuilt(dateBuilt);
        home.setValue(value);
        home.setDwellingType(DwellingType.valueOf(dwellingType));
        home.setHeatingType(HeatingType.valueOf(heatingType));
        home.setLocation(Location.valueOf(location));

        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            home.setUser(optionalUser.get());
            homeRepository.save(home);
            return "The home has been saved into the database.";
        } else {
            return "The home failed to be saved into the database.";
        }
    }

    /**
     * Put Mapping for Home based on ID - update home
     *
     * @param user_id      user id
     * @param home_id      home id
     * @param dateBuilt    date built
     * @param value        value
     * @param dwellingType dwelling type
     * @param heatingType  heating type
     * @param location     location
     */
    @PutMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES + "/{home_id}")
    public @ResponseBody String updateHome(@PathVariable Integer user_id, @PathVariable Integer home_id,
                                           @RequestParam LocalDate dateBuilt,
                                           @RequestParam double value,
                                           @RequestParam("dwellingType") String dwellingType,
                                           @RequestParam("heatingType") String heatingType,
                                           @RequestParam("location") String location) {

        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<Home> optionalHome = homeRepository.findById(home_id);
            if (optionalHome.isPresent()) {
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
     *
     * @param user_id user id
     * @param home_id home id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMES + "/{home_id}")
    public @ResponseBody String deleteHome(@PathVariable Integer user_id, @PathVariable Integer home_id) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<Home> optionalHome = homeRepository.findById(home_id);
            if (optionalHome.isPresent()) {
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
     *
     * @return Iterable of all autos
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.AUTOS)
    public @ResponseBody Iterable<Vehicle> getAllAutos() {
        return autoRepository.findAll();
    }

    /**
     * Get all autos by user
     *
     * @param user_id user id
     * @return Iterable of all autos by user
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOS)
    public @ResponseBody Iterable<Vehicle> getAllAutosByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<Vehicle> autos = new LinkedList<>();

        if (user.isPresent()) {
            autos = autoRepository.getAllByUserId(user.get().getId());
        }
        return autos;
    }

    /**
     * Get auto by id
     *
     * @param user_id user id
     * @param year    year
     * @param model   model
     * @param make    make
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
        if (optionalUser.isPresent()) {
            vehicle.setUser(optionalUser.get());
            autoRepository.save(vehicle);
            return "The auto has been saved into the database.";
        } else {
            return "The auto failed to be saved into the database.";
        }
    }

    /**
     * Delete Mapping for Auto based on ID
     *
     * @param user_id user id
     * @param auto_id auto id
     * @return message stating success / failure
     */
    @PutMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOS + "/{auto_id}")
    public @ResponseBody String updateAuto(@PathVariable(name = "user_id") Integer user_id,
                                           @PathVariable(name = "auto_id") Integer auto_id,
                                           @RequestParam int year,
                                           @RequestParam String model,
                                           @RequestParam String make) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<Vehicle> optionalAuto = autoRepository.findById(auto_id);
            if (optionalAuto.isPresent()) {
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
     *
     * @param user_id user id
     * @param auto_id auto id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOS + "/{auto_id}")
    public @ResponseBody String deleteAuto(@PathVariable Integer user_id,
                                           @PathVariable Integer auto_id) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<Vehicle> optionalAuto = autoRepository.findById(auto_id);
            if (optionalAuto.isPresent()) {
                autoRepository.deleteById(auto_id);
                return "The auto has been deleted from the database.";
            } else {
                return "Auto not found.";
            }
        } else {
            return "User not found.";
        }
    }

    // Driver - if a user chooses to go with auto, create a driver object for the user

    /**
     * Get all drivers
     *
     * @return return all drivers
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.DRIVERS)
    public @ResponseBody Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    /**
     * Get drivers by ID
     *
     * @param user_id user id
     * @return return all drivers by user ID
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.DRIVERS)
    public @ResponseBody Iterable<Driver> getAllDriversByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<Driver> drivers = new LinkedList<>();

        if (user.isPresent()) {
            drivers = driverRepository.getAllByUserId(user.get().getId());
        }
        return drivers;
    }

    /**
     * Add a new driver
     *
     * @param user_id         user id
     * @param age             age
     * @param address         address
     * @param numberAccidents number of accidents
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.DRIVERS)
    public @ResponseBody String addNewDriver(@PathVariable(name = "user_id") Integer user_id,
                                             @RequestParam int age,
                                             @RequestParam String address,
                                             @RequestParam int numberAccidents) {
        Driver driver = new Driver();
        driver.setAge(age);
        driver.setAddress(address);
        driver.setNumberAccidents(numberAccidents);

        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            driver.setUser(optionalUser.get());
            driverRepository.save(driver);
            return "The driver has been saved into the database.";
        } else {
            return "The driver failed to be saved into the database.";
        }
    }

    /**
     * Put Mapping for Driver based on ID - update driver
     *
     * @param user_id   user id
     * @param driver_id driver id
     * @return message stating success / failure
     */
    @PutMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.DRIVERS + "/{driver_id}")
    public @ResponseBody String updateDriver(@PathVariable(name = "user_id") Integer user_id,
                                             @PathVariable(name = "driver_id") Integer driver_id,
                                             @RequestParam int age,
                                             @RequestParam String address,
                                             @RequestParam int numberAccidents) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<Driver> optionalDriver = driverRepository.findById(driver_id);
            if (optionalDriver.isPresent()) {
                Driver driver = optionalDriver.get();
                driver.setAge(age);
                driver.setAddress(address);
                driver.setNumberAccidents(numberAccidents);
                driverRepository.save(driver);
                return "The driver has been updated in the database.";
            } else {
                return "Driver not found.";
            }
        } else {
            return "User not found.";
        }
    }

    /**
     * Delete Mapping for Driver based on ID - delete driver
     *
     * @param user_id   user id
     * @param driver_id driver id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.DRIVERS + "/{driver_id}")
    public @ResponseBody String deleteDriver(@PathVariable Integer user_id,
                                             @PathVariable Integer driver_id) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<Driver> optionalDriver = driverRepository.findById(driver_id);
            if (optionalDriver.isPresent()) {
                driverRepository.deleteById(driver_id);
                return "The driver has been deleted from the database.";
            } else {
                return "Driver not found.";
            }
        } else {
            return "User not found.";
        }
    }

    // Homeowner - if a user chooses to go with home, create a Homeowner object for the user

    /**
     * Get all homeowners
     * @return return all homeowners
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.HOMEOWNERS)
    public @ResponseBody Iterable<HomeOwner> getAllHomeowners() {
        return homeownerRepository.findAll();
    }

    /**
     * Get a homeowner by ID
     * @param user_id user id
     * @return return all homeowners by user ID
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEOWNERS)
    public @ResponseBody Iterable<HomeOwner> getAllHomeownersByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<HomeOwner> homeowners = new LinkedList<>();

        if (user.isPresent()) {
            homeowners = homeownerRepository.getAllByUserId(user.get().getId());
        }
        return homeowners;
    }

    /**
     * Post Mapping for Homeowner - Add a new homeowner
     * @param user_id user id
     * @param age age
     * @param address address
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEOWNERS)
    public @ResponseBody String addNewHomeowner(@PathVariable(name = "user_id") Integer user_id,
                                                @RequestParam int age,
                                                @RequestParam String address) {
        HomeOwner homeowner = new HomeOwner();
        homeowner.setAge(age);
        homeowner.setAddress(address);

        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            homeowner.setUser(optionalUser.get());
            homeownerRepository.save(homeowner);
            return "The homeowner has been saved into the database.";
        } else {
            return "The homeowner failed to be saved into the database.";
        }
    }

    /**
     * Put Mapping for Homeowner based on ID - update homeowner
     * @param user_id user id
     * @param homeowner_id homeowner id
     * @param age age
     * @param address address
     * @return message stating success / failure
     */
    @PutMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEOWNERS + "/{homeowner_id}")
    public @ResponseBody String updateHomeowner(@PathVariable(name = "user_id") Integer user_id,
                                                @PathVariable(name = "homeowner_id") Integer homeowner_id,
                                                @RequestParam int age,
                                                @RequestParam String address) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<HomeOwner> optionalHomeowner = homeownerRepository.findById(homeowner_id);
            if (optionalHomeowner.isPresent()) {
                HomeOwner homeowner = optionalHomeowner.get();
                homeowner.setAge(age);
                homeowner.setAddress(address);
                homeownerRepository.save(homeowner);
                return "The homeowner has been updated in the database.";
            } else {
                return "Homeowner not found.";
            }
        } else {
            return "User not found.";
        }
    }

    /**
     * Delete Mapping for Homeowner based on ID - delete homeowner
     * @param user_id user id
     * @param homeowner_id homeowner id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEOWNERS + "/{homeowner_id}")
    public @ResponseBody String deleteHomeowner(@PathVariable Integer user_id,
                                                @PathVariable Integer homeowner_id) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Optional<HomeOwner> optionalHomeowner = homeownerRepository.findById(homeowner_id);
            if (optionalHomeowner.isPresent()) {
                homeownerRepository.deleteById(homeowner_id);
                return "The homeowner has been deleted from the database.";
            } else {
                return "Homeowner not found.";
            }
        } else {
            return "User not found.";
        }
    }

    // AutoQuote
    /**
     * Get all auto quotes
     * @return return all auto quotes
     */
    @GetMapping(path = RESTNamebook.USERS  + RESTNamebook.AUTOQUOTES)
    public @ResponseBody Iterable<AutoQuote> getAllAutoQuotes() {
        return autoQuoteRepository.findAll();
    }

    /**
     * Get all auto quotes by user
     * @param user_id user id
     * @return return all auto quotes by user
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOQUOTES)
    public @ResponseBody Iterable<AutoQuote> getAllAutoQuotesByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<AutoQuote> autoQuotes = new LinkedList<>();

        if (user.isPresent()) {
            autoQuotes = autoQuoteRepository.getAllByUserId(user.get().getId());
        }
        return autoQuotes;
    }

    /**
     * Post Mapping for AutoQuote - Add a new auto quote
     * @param user_id user id
     * @param auto_id auto id
     * @return message stating success
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOQUOTES + "/{auto_id}")
    public @ResponseBody String addNewAutoQuote(@PathVariable(name = "user_id") Integer user_id,
                                                @PathVariable(name = "auto_id") Integer auto_id) {
        Optional<User> user = userRepository.findById(user_id);
        Optional<Driver> driver = driverRepository.getDriverByUserId(user_id);
        Optional<Vehicle> auto = autoRepository.findById(auto_id);
        if (user.isPresent()){
            if (driver.isPresent()){
                if (auto.isPresent()){
                    AutoQuote autoQuote = AutoQuoteFactory.createAutoQuote(auto.get(), driver.get());
                    autoQuote.setUser(user.get());
                    autoQuoteRepository.save(autoQuote);
                } else {
                    return "You haven't entered your vehicle information yet.";
                }
            } else {
                return "You haven't entered your driver information yet.";
            }
            return "The auto quote has been saved into the database.";
        } else {
            return "User not found";
        }
    }

    /**
     * Delete Mapping for AutoQuote based on ID - delete auto quote
     * @param user_id user id
     * @param autoquote_id auto quote id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOQUOTES + "/{autoquote_id}")
    public @ResponseBody String deleteAutoQuote(@PathVariable(name = "user_id") Integer user_id,
                                                @PathVariable(name = "autoquote_id") Integer autoquote_id) {
        Optional<AutoQuote> autoQuote = autoQuoteRepository.findById(autoquote_id);
        if (autoQuote.isPresent()){
            Optional<User> user = userRepository.findById(user_id);
            if (user.isPresent() && Objects.equals(autoQuote.get().getInsuredPerson().getUser().getId(), user.get().getId())){
                autoQuoteRepository.deleteById(autoquote_id);
                return "The auto quote has been deleted from the database.";
            } else {
                return "User not found.";
            }
        } else {
            return "Auto quote not found.";
        }
    }

    // Home Quote
    /**
     * Get all home quotes
     * @return return all home quotes
     */
    @GetMapping(path = RESTNamebook.USERS  + RESTNamebook.HOMEQUOTES)
    public @ResponseBody Iterable<HomeQuote> getAllHomeQuotes() {
        return homeQuoteRepository.findAll();
    }

    /**
     * Get all home quotes by user
     * @param user_id user id
     * @return return all home quotes by user
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEQUOTES)
    public @ResponseBody Iterable<HomeQuote> getAllHomeQuotesByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<HomeQuote> homeQuotes = new LinkedList<>();

        if (user.isPresent()) {
            homeQuotes = homeQuoteRepository.getAllByUserId(user.get().getId());
        }
        return homeQuotes;
    }

    /**
     * Post Mapping for HomeQuote - Add a new home quote
     * @param user_id user id
     * @param home_id home id
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEQUOTES + "/{home_id}")
    public @ResponseBody String addNewHomeQuote(@PathVariable(name = "user_id") Integer user_id,
                                                @PathVariable(name = "home_id") Integer home_id) {
        Optional<User> user = userRepository.findById(user_id);
        Optional<HomeOwner> homeowner = homeownerRepository.findById(home_id);
        Optional<Home> home = homeRepository.findById(home_id);
        if (user.isPresent()){
            if (homeowner.isPresent()){
                if (home.isPresent()){
                    HomeQuote homeQuote = HomeQuoteFactory.createHomeQuote(home.get(), homeowner.get());
                    homeQuote.setUser(user.get());
                    homeQuoteRepository.save(homeQuote);
                } else {
                    return "You haven't entered your home information yet.";
                }
            } else {
                return "You haven't entered your homeowner information yet.";
            }
            return "The home quote has been saved into the database.";
        } else {
            return "User not found";
        }
    }

    /**
     * Delete Mapping for HomeQuote based on ID - delete home quote
     * @param user_id user id
     * @param homequote_id home quote id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEQUOTES + "/{homequote_id}")
    public @ResponseBody String deleteHomeQuote(@PathVariable(name = "user_id") Integer user_id,
                                                @PathVariable(name = "homequote_id") Integer homequote_id) {
        Optional<HomeQuote> homeQuote = homeQuoteRepository.findById(homequote_id);
        if (homeQuote.isPresent()) {
            Optional<User> user = userRepository.findById(user_id);
            if (user.isPresent() && Objects.equals(homeQuote.get().getInsuredPerson().getUser().getId(), user.get().getId())) {
                homeQuoteRepository.deleteById(homequote_id);
                return "The home quote has been deleted from the database.";
            } else {
                return "User not found.";
            }
        } else {
            return "Home quote not found.";
        }
    }

    // Auto Policy
    /**
     * Get all auto policies
     * @return return all auto policies
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.AUTOPOLICIES)
    public @ResponseBody Iterable<AutoPolicy> getAllAutoPolicies() {
        return autoPolicyRepository.findAll();
    }

    /**
     * Get all auto policies by user
     * @param user_id user id
     * @return return all auto policies by user
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOPOLICIES)
    public @ResponseBody Iterable<AutoPolicy> getAllAutoPoliciesByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<AutoPolicy> autoPolicies = new LinkedList<>();

        if (user.isPresent()) {
            autoPolicies = autoPolicyRepository.getAllByUserId(user.get().getId());
        }
        return autoPolicies;
    }

    /**
     * Post Mapping for AutoPolicy - Add a new auto policy
     * @param user_id user id
     * @param autoquote_id auto quote id
     * @return message stating success
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOPOLICIES + "/{autoquote_id}")
    public @ResponseBody String addNewAutoPolicy(@PathVariable(name = "user_id") Integer user_id,
                                                 @PathVariable(name = "autoquote_id") Integer autoquote_id) {
        Optional<User> user = userRepository.findById(user_id);
        Optional<AutoQuote> autoQuote = autoQuoteRepository.findById(autoquote_id);
        if (user.isPresent()){
            if (autoQuote.isPresent()){
                AutoPolicy autoPolicy = AutoPolicyFactory.createAutoPolicy(autoQuote.get());
                autoPolicy.setUser(user.get());
                autoPolicyRepository.save(autoPolicy);
                return "The auto policy has been saved into the database.";
            } else {
                return "You haven't entered your auto quote information yet.";
            }
        } else {
            return "User not found";
        }
    }

    /**
     * Delete Mapping for AutoPolicy based on ID - delete auto policy
     * @param user_id user id
     * @param autopolicy_id auto policy id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.AUTOPOLICIES + "/{autopolicy_id}")
    public @ResponseBody String deleteAutoPolicy(@PathVariable(name = "user_id") Integer user_id,
                                                 @PathVariable(name = "autopolicy_id") Integer autopolicy_id) {
        Optional<AutoPolicy> autoPolicy = autoPolicyRepository.findById(autopolicy_id);
        if (autoPolicy.isPresent()) {
            Optional<User> user = userRepository.findById(user_id);
            if (user.isPresent() && Objects.equals(autoPolicy.get().getInsuredPerson().getUser().getId(), user.get().getId())) {
                autoPolicyRepository.deleteById(autopolicy_id);
                return "The auto policy has been deleted from the database.";
            } else {
                return "User not found.";
            }
        } else {
            return "Auto policy not found.";
        }
    }

    /**
     * Get all home policies
     * @return return all home policies
     */
    @GetMapping(path = RESTNamebook.USERS + RESTNamebook.HOMEPOLICIES)
    public @ResponseBody Iterable<HomePolicy> getAllHomePolicies() {
        return homePolicyRepository.findAll();
    }

    /**
     * Get all home policies by user
     * @param user_id user id
     * @return return all home policies by user
     */
    @GetMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEPOLICIES)
    public @ResponseBody Iterable<HomePolicy> getAllHomePoliciesByUser(@PathVariable(name = "user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);
        Iterable<HomePolicy> homePolicies = new LinkedList<>();

        if (user.isPresent()) {
            homePolicies = homePolicyRepository.getAllByUserId(user.get().getId());
        }
        return homePolicies;
    }

    /**
     * Post Mapping for HomePolicy based on ID - create a home policy
     * @param user_id user id
     * @param homequote_id home policy id
     * @return message stating success / failure
     */
    @PostMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEPOLICIES + "/{homequote_id}")
    public @ResponseBody String addNewHomePolicy(@PathVariable(name = "user_id") Integer user_id,
                                                 @PathVariable(name = "homequote_id") Integer homequote_id) {
        Optional<User> user = userRepository.findById(user_id);
        Optional<HomeQuote> homeQuote = homeQuoteRepository.findById(homequote_id);
        if (user.isPresent()){
            if (homeQuote.isPresent()){
                HomePolicy homePolicy = HomePolicyFactory.createHomePolicy(homeQuote.get());
                homePolicy.setUser(user.get());
                homePolicyRepository.save(homePolicy);
                return "The home policy has been saved into the database.";
            } else {
                return "You haven't entered your home quote information yet.";
            }
        } else {
            return "User not found";
        }
    }

    /**
     * Delete Mapping for HomePolicy based on ID - delete home policy
     * @param user_id user id
     * @param homepolicy_id home policy id
     * @return message stating success / failure
     */
    @DeleteMapping(path = RESTNamebook.USERS + "/{user_id}" + RESTNamebook.HOMEPOLICIES + "/{homepolicy_id}")
    public @ResponseBody String deleteHomePolicy(@PathVariable(name = "user_id") Integer user_id,
                                                 @PathVariable(name = "homepolicy_id") Integer homepolicy_id) {
        Optional<HomePolicy> homePolicy = homePolicyRepository.findById(homepolicy_id);
        if (homePolicy.isPresent()) {
            Optional<User> user = userRepository.findById(user_id);
            if (user.isPresent()) {
                homePolicyRepository.deleteById(homepolicy_id);
                return "The home policy has been deleted from the database.";
            } else {
                return "User not found.";
            }
        } else {
            return "Home policy not found.";
        }
    }
}