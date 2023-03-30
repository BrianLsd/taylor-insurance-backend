package com.example.capstone.POJOS;

/**
 * Extends Person Abstract class
 * Creates Driver objects having an age, address, and number of accidents
 */
public class Driver extends Person {

    private int age;

    private String address;

    private int numberAccidents;

    /**
     * A constructor to create Driver objects
     * @param age The age of the Driver object
     * @param address The address of the Driver object
     * @param numberAccidents The number of accidents the Driver object has had
     */
    public Driver(int age, String address, int numberAccidents) {
        super(age, address);
        this.age = age;
        this.address = address;
        this.numberAccidents = numberAccidents;
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
}