package com.example.capstone.POJOS;

import com.example.capstone.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Creates Home objects having a date built, dollar value, dwelling type, heating type, and location.
 */
@Entity(name = "home")
public class Home {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd")  private LocalDate dateBuilt;
    private double value;
    @Enumerated(EnumType.ORDINAL) private DwellingType dwellingType;
    @Enumerated(EnumType.ORDINAL) private HeatingType heatingType;
    @Enumerated(EnumType.ORDINAL) private Location location;

    @ManyToOne @JoinColumn(name = "user_id") private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the date the Home was built
     * @return dateBuilt The date the Home object was built
     */
    public LocalDate getdateBuilt() {
        return dateBuilt;
    }

    /**
     * Sets the date the Home was built
     * @param dateBuilt The date the Home object was built
     */
    public void setDateBuilt(LocalDate dateBuilt) {
        this.dateBuilt = dateBuilt;
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

    /**
     * Gets the value of the user object
     * @return user Homeowner
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of user object
     * @param user Homeowner
     */
    public void setUser(User user) {
        this.user = user;
    }
}