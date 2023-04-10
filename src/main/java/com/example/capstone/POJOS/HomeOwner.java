package com.example.capstone.POJOS;

import com.example.capstone.User;
import jakarta.persistence.*;

/**
 * Extends Person Abstract class
 * Creates HomeOwner objects having an age and address
 */

@Entity(name = "homeowner")
public class HomeOwner extends Person{

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    private int age;
    private String address;

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
     * Gets the age of the HomeOwner object
     * @return age The age of the HomeOwner object
     */
    @Override
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the HomeOwner object
     * @param age The age of the HomeOwner object
     */
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the address of the HomeOwner object
     * @return address The address of the HomeOwner object
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the HomeOwner object
     * @param address The address of the HomeOwner object
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the value of user object
     * @return User Auto owner
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
