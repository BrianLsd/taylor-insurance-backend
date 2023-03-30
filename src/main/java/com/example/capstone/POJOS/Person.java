package com.example.capstone.POJOS;

/**
 * An abstract class to be extended by concrete person classes
 */
public abstract class Person {
    private int age;
    private String address;

    /**
     * A constructor to create Person objects
     * @param age The age of the Person object
     * @param address The address of the Person object
     */
    public Person(int age, String address) {
        this.age = age;
        this.address = address;
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