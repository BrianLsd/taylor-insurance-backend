package com.example.capstone.POJOS;

import com.example.capstone.User;
import jakarta.persistence.*;

/**
 * Extends Policy Abstract class
 * Creates AutoPolicy objects having a driver, vehicle, liability limit, deductible base premium, and tax
 */
@Entity(name = "autopolicy")
public class AutoPolicy extends Policy {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    @OneToOne private final Driver driver;
    @OneToOne private final Vehicle vehicle;
    private final double liabilityLimit;
    private final double deductible;
    private final double basePremium;
    private final double tax;
    private final double totalPremium;

    @ManyToOne @JoinColumn(name = "user_id") private User user;

    protected AutoPolicy() {
        super(null, 0);
        this.driver = null;
        this.vehicle = null;
        this.liabilityLimit = 0;
        this.deductible = 0;
        this.basePremium = 0;
        this.tax = 0;
        this.totalPremium = 0;
    }

    /**
     * A constructor to create Auto Policy objects
     * @param builder The Builder object to build a policy
     */
    public AutoPolicy(Builder builder) {
        super(builder.driver, builder.totalPremium);
        this.driver = builder.driver;
        this.vehicle = builder.vehicle;
        this.liabilityLimit = builder.liabilityLimit;
        this.deductible = builder.deductible;
        this.basePremium = builder.basePremium;
        this.tax = builder.tax;
        this.totalPremium = builder.totalPremium;
    }

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
     * Gets the insured person object of the Policy object
     * @return A Person object representing a policy's insured person
     */
    @Override
    public Driver getInsuredPerson() {
        return driver;
    }

    /**
     * Gets a Vehicle object of an Auto Policy
     * @return A vehicle object representing the vehicle of this Auto Policy
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Gets the liability limit of an Auto Policy
     * @return A numeric value representing the liability limit of an Auto Policy
     */
    public double getLiabilityLimit() {
        return liabilityLimit;
    }

    /**
     * Gets the deductible of an Auto Policy
     * @return A numeric value representing the deductible of an Auto Policy
     */
    public double getDeductible() {
        return deductible;
    }

    /**
     * Gets the Driver object of this Auto Policy
     * @return A Driver object representing the Driver for this Auto Policy
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Gets the base premium of an Auto Policy
     * @return A numeric value representing the base premium of an Auto Policy
     */
    public double getBasePremium() {
        return basePremium;
    }

    /**
     * Gets the tax of the AutoPolicy object
     * @return A numeric value representing the tax of an AutoPolicy object
     */
    public double getTax() {
        return tax;
    }

    /**
     * Gets the total premium of the AutoPolicy object
     * @return A numeric value representing the total premium of an AutoPolicy object
     */
    public double getTotalPremium() {
        return totalPremium;
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

    /**
     * Create Builder objects with a Driver, Vehicle, liability limit, deductible, base premium, tax, and total premium
     */
    public static class Builder{
        private final Driver driver;
        private final Vehicle vehicle;
        private final double liabilityLimit;
        private final double deductible;
        private final double basePremium;
        private final double tax;
        private final double totalPremium;

        /**
         * A constructor to create builder objects
         * @param driver The driver
         * @param vehicle The vehicle
         * @param liabilityLimit The liability limit
         * @param deductible the deductible
         * @param basePremium The base premium
         * @param tax The tax
         * @param totalPremium The total premium value
         */
        public Builder(Driver driver, Vehicle vehicle, double liabilityLimit, double deductible, double basePremium,
                       double tax, double totalPremium){
            this.driver = driver;
            this.vehicle = vehicle;
            this.liabilityLimit = liabilityLimit;
            this.deductible = deductible;
            this.basePremium = basePremium;
            this.tax = tax;
            this.totalPremium = totalPremium;
        }

        /**
         * Initialize and get a new AutoPolicy
         * @return An AutoPolicy object
         */
        public AutoPolicy build(){
            return new AutoPolicy(this);
        }
    }
}


