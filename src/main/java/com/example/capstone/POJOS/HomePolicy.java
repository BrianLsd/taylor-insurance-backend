package com.example.capstone.POJOS;

import com.example.capstone.User;
import jakarta.persistence.*;

/**
 * Extends Policy Abstract class to create Policies
 */
@Entity(name = "homepolicy")
public class HomePolicy extends Policy {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    @OneToOne private final HomeOwner homeOwner;
    @OneToOne private final Home home;
    private final double liabilityLimit;
    private final double deductible;
    private final double contentsInsuranceLimit;
    private final double contentsDeductible;
    private final double basePremium;
    private final double tax;
    private final double totalPremium;

    @ManyToOne @JoinColumn(name = "user_id") private User user;

    protected HomePolicy() {
        super(null, 0);
        this.homeOwner = null;
        this.home = null;
        this.liabilityLimit = 0;
        this.deductible = 0;
        this.contentsInsuranceLimit = 0;
        this.contentsDeductible = 0;
        this.basePremium = 0;
        this.tax = 0;
        this.totalPremium = 0;
    }

    /**
     * A constructor to build Home Policies
     * @param builder A Builder object to build a Home Policy
     */
    private HomePolicy(Builder builder) {
        super(builder.homeOwner, builder.totalPremium);
        this.homeOwner = builder.homeOwner;
        this.home = builder.home;
        this.contentsInsuranceLimit = builder.contentsInsuranceLimit;
        this.contentsDeductible = builder.contentsDeductible;
        this.liabilityLimit = builder.liabilityLimit;
        this.deductible = builder.deductible;
        this.basePremium =builder.basePremium;
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
     * Gets a Home object
     * @return A home object representing the home in a Policy
     */
    public Home getHome() {
        return home;
    }

    /**
     * Gets the liability limit of a Home Policy object
     * @return A numeric value representing the liability limit of a Home Policy object
     */
    public double getLiabilityLimit() {
        return liabilityLimit;
    }

    /**
     * Gets the deductible of a Home Policy object
     * @return A numeric value representing the deductible of a Home Policy object
     */
    public double getDeductible() {
        return deductible;
    }

    /**
     * Gets the Contents Insurance Limit of a Home Policy object
     * @return A numeric value representing the Contents Insurance Limit of a Home Policy object
     */
    public double getContentsInsuranceLimit() {
        return contentsInsuranceLimit;
    }

    /**
     * Gets the Contents Deductible of a Home Policy object
     * @return A numeric value representing the Contents Deductible of a Home Policy object
     */
    public double getContentsDeductible() {
        return contentsDeductible;
    }

    /**
     * Gets the Base Premium of a Home Policy object
     * @return A numeric value representing the Base Premium of a Home Policy object
     */
    public double getBasePremium() {
        return basePremium;
    }

    /**
     * Gets the Tax of a Home Policy object
     * @return A numeric value representing the Tax value of a Home Policy object
     */
    public double getTax() {
        return tax;
    }

    /**
     * Gets the Home-Owner of a Home Policy object
     * @return A HomeOwner object representing the Home-Owner of a Home Policy object
     */
    @Override
    public HomeOwner getInsuredPerson() {
        return homeOwner;
    }

    /**
     * Gets the Total Premium of a Home Policy object
     * @return A numeric value representing the Total Premium of a Home Policy object
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
     * Create Builder objects with a Home-Owner, Home, liability limit, deductible,
     * ... Contents Insurance Limit, Contents Deductible, Total Premium,
     * ... Base premium, Tax
     */
    public static class Builder {
        private final HomeOwner homeOwner;
        private final Home home;
        private final double liabilityLimit;
        private final double deductible;
        private final double contentsInsuranceLimit;
        private final double contentsDeductible;
        private final double totalPremium;
        private final double basePremium;
        private final double tax;

        /**
         * A constructor to create builder objects
         * @param homeOwner The home-owner object
         * @param home The home object
         * @param liabilityLimit The liability limit
         * @param deductible The deductible
         * @param contentsInsuranceLimit The contents insurance limit
         * @param contentsDeductible The content deductible
         * @param basePremium The base premium
         * @param tax The tax
         * @param totalPremium The Total premium
         */
        public Builder(HomeOwner homeOwner, Home home,double liabilityLimit, double deductible,
                       double contentsInsuranceLimit, double contentsDeductible, double basePremium,
                       double tax, double totalPremium){
            this.homeOwner = homeOwner;
            this.home = home;
            this.liabilityLimit = liabilityLimit;
            this.deductible = deductible;
            this.contentsInsuranceLimit = contentsInsuranceLimit;
            this.contentsDeductible = contentsDeductible;
            this.basePremium = basePremium;
            this.tax = tax;
            this.totalPremium = totalPremium;
        }

        /**
         * Initialize and get a new Home Policy
         * @return A Home Policy object
         */
        public HomePolicy build(){
            return new HomePolicy(this);
        }
    }
}

