package com.example.capstone.POJOS;

/**
 * Extends Policy Abstract class to create Policies
 */
public class HomePolicy extends Policy {
    private final HomeOwner homeOwner;
    private final Home home;
    private final double liabilityLimit;
    private final double deductible;
    private final double contentsInsuranceLimit;
    private final double contentsDeductible;
    private final double basePremium;
    private final double tax;

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
    public HomeOwner getHomeOwner() {
        return homeOwner;
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

