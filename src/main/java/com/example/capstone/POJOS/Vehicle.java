package com.example.capstone.POJOS;

/**
 * Create Vehicle objects having a year, model and make of the vehicle
 */
public class Vehicle {

    private int year;
    private String model;
    private String make;

    /**
     * A Constructor to create vehicle objects
     * @param year The vehicle year
     * @param model The vehicle model
     * @param make The vehicle make
     */
    public Vehicle(int year, String model, String make) {
        this.year = year;
        this.model = model;
        this.make = make;
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
}