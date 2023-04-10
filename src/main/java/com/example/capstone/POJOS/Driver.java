package com.example.capstone.POJOS;

import com.example.capstone.User;
import jakarta.persistence.*;

/**
 * Extends Person Abstract class
 * Creates Driver objects having an age, address, and number of accidents
 */
@Entity(name = "driver")
public class Driver extends Person {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    private int age;
    private String address;
    private int numberAccidents;

    @OneToOne @JoinColumn(name = "user_id") private User user;

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
     * Gets the number of accidents of the Person object
     * @return numberAccidents The number of accidents of the Person object
     */
    public int getNumberAccidents() {
        return numberAccidents;
    }

    /**
     * Sets the number of accidents of the Person object
     * @param numberAccidents The number of accidents of the Person object
     */
    public void setNumberAccidents(int numberAccidents) {
        this.numberAccidents = numberAccidents;
    }

    /**
     * Gets the age of the Person object
     * @return age The age of the Person object
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the Person object
     * @param age The age of the Person object
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the address of the Person object
     * @return address The address of the Person object
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the Person object
     * @param address The address of the Person object
     */
    public void setAddress(String address) {
        this.address = address;
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