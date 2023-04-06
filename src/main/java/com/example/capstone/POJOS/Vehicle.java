package com.example.capstone.POJOS;

import com.example.capstone.User;
import jakarta.persistence.*;

/**
 * Create Vehicle objects having a year, model and make of the vehicle
 */
@Entity(name = "auto")
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    private int year;
    private String model;
    private String make;

    @ManyToOne @JoinColumn(name = "user_id") private User user;

    /**
     * Gets the id of a vehicle object
     * @return An integer representing the vehicle's id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Receives an integer parameter and sets it as the id of a vehicle object
     * @param id An integer representing the vehicle's id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the year of a vehicle object
     * @return An integer representing the vehicle's year of make
     */
    public int getYear() {
        return year;
    }

    /**
     * Receives an integer parameter and sets it as the year of a vehicle object
     * @param year An integer representing the vehicle's year of make
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the model of a vehicle object
     * @return A string representing the vehicle's model
     */
    public String getModel() {
        return model;
    }

    /**
     * Receives a String parameter and sets it as the model of a vehicle object
     * @param model A string representing the vehicle's model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the make of a vehicle object
     * @return A string representing the vehicle's make
     */
    public String getMake() {
        return make;
    }

    /**\
     * Receives a String parameter and sets it as the make of a vehicle object
     * @param make A string representing the vehicle's year of make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the value of the user object
     * @return user Auto owner
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of user object
     * @param user Auto owner
     */
    public void setUser(User user) {
        this.user = user;
    }
}