package com.example.capstone.POJOS;

/**
 * Extends Person Abstract class
 * Creates HomeOwner objects having an age and address
 */
public class HomeOwner extends Person{
    private int age;
    private String address;

    /**
     * A constructor to create HomeOwner objects
     * @param age The age of the HomeOwner object
     * @param address The address of the HomeOwner object
     */
    public HomeOwner(int age, String address) {
        super(age, address);
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
}
