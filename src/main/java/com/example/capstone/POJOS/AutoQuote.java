package com.example.capstone.POJOS;

/**
 * Extends Quote Abstract class to create Auto Quotes
 */
public class AutoQuote extends Quote{
    private final Driver driver;
    private final Vehicle vehicle;
    private final double liabilityLimit;
    private final double deductible;
    private final double basePremium;
    private final double tax;

    /**
     * A constructor to build Auto Quotes
     * @param builder A Builder object to build an Auto Quote
     */
    public AutoQuote(Builder builder) {
        super(builder.driver, builder.totalPremium);
        this.driver = builder.driver;
        this.vehicle = builder.vehicle;
        this.liabilityLimit = builder.liabilityLimit;
        this.deductible = builder.deductible;
        this.basePremium = builder.basePremium;
        this.tax = builder.tax;
    }

    /**
     * Gets a Driver object
     * @return A Driver object representing the Insured Person in an Auto Quote
     */
    @Override
    public Driver getInsuredPerson() {
        return driver;
    }

    /**
     * Gets a Vehicle object
     * @return A Vehicle object representing the Vehicle in an Auto Quote
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Gets the liability limit of a Home Quote object
     * @return A numeric value representing the liability limit of a Home Quote object
     */
    public double getLiabilityLimit() {
        return liabilityLimit;
    }

    /**
     * Gets the deductible of a Home Quote object
     * @return A numeric value representing the deductible of a Home Quote object
     */
    public double getDeductible() {
        return deductible;
    }

    /**
     * Gets a Driver object
     * @return A Driver object representing the Driver in an Auto Quote
     */
    @Override
    public Driver getDriver() {
        return driver;
    }

    /**
     * Gets the Base Premium of a Home Quote object
     * @return A numeric value representing the Base Premium of a Home Quote object
     */
    public double getBasePremium() {
        return basePremium;
    }

    /**
     * Gets the Tax of a Home Quote object
     * @return A numeric value representing the Tax value of a Home Quote object
     */
    public double getTax() {
        return tax;
    }

    /**
     * Use to create Auto Quotes
     */
    public static class Builder {
        private final Driver driver;
        private final Vehicle vehicle;
        private final double liabilityLimit;
        private final double deductible;
        private final double basePremium;
        private final double tax;
        private final double totalPremium;

        /**
         * A constructor to create builder objects
         * @param driver The Driver object
         * @param vehicle The Vehicle object
         * @param liabilityLimit The liability limit
         * @param deductible The deductible
         * @param basePremium The base premium
         * @param tax The tax amount
         * @param totalPremium the total premium value
         */
        public Builder(Driver driver, Vehicle vehicle, double liabilityLimit, double deductible,
                       double basePremium, double tax, double totalPremium) {
            this.driver = driver;
            this.vehicle = vehicle;
            this.liabilityLimit = liabilityLimit;
            this.deductible = deductible;
            this.basePremium = basePremium;
            this.tax = tax;
            this.totalPremium = totalPremium;
        }

        /**
         * Initialize and get a new Auto Quote
         * @return An Auto Quote object
         */
        public AutoQuote build(){
            return new AutoQuote(this);
        }
    }
}

