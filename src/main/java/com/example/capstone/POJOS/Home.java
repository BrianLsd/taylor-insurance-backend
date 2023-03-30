package com.example.capstone.POJOS;

/**
 * Creates Home objects having an age, dwelling type, heating type, location, and value
 */
public class Home {

    private int age;
    private DwellingType dwellingType;
    private HeatingType heatingType;
    private Location location;
    private double value;

    /**
     * A constructor to create Home objects
     * @param age The age of the home
     * @param dwellingType The dwelling type of the home
     * @param heatingType The heating type of the home
     * @param location The location of the home
     * @param value The value of the home
     */
    public Home(int age, DwellingType dwellingType, HeatingType heatingType,
                Location location, double value) {
        this.age = age;
        this.dwellingType = dwellingType;
        this.heatingType = heatingType;
        this.location = location;
        this.value = value;
    }

    /**
     * Gets the age of the Home object
     * @return age The age of the Home object
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the Home object
     * @param age The age of the Home object
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the dwelling type of the Home object
     * @return dwellingType The dwelling type of the Home object
     */
    public DwellingType getDwellingType() {
        return dwellingType;
    }

    /**
     * Sets the dwelling type of the Home object
     * @param dwellingType The dwelling type of the Home object
     */
    public void setDwellingType(DwellingType dwellingType) {
        this.dwellingType = dwellingType;
    }

    /**
     * Gets the heating type of the Home object
     * @return heatingType The heating type of the Home object
     */
    public HeatingType getHeatingType() {
        return heatingType;
    }

    /**
     * Sets the heatinging type of the Home object
     * @param heatingType The heating type of the Home object
     */
    public void setHeatingType(HeatingType heatingType) {
        this.heatingType = heatingType;
    }

    /**
     * Gets the location of the Home object
     * @return location The location of the Home object
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the location of the Home object
     * @param location The location of the Home object
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets the value of the Home object
     * @return value The value of the Home object
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the Home object
     * @param value The value of the Home object
     */
    public void setValue(double value) {
        this.value = value;
    }
}