package com.example.capstone.POJOS;

import java.time.LocalDate;

/**
 * An abstract class to be extended by concrete quote classes
 */
public abstract class Quote {
    private final Person insuredPerson;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double totalPremium;

    /**
     * A constructor to create Quote objects
     * @param driver The driver object
     * @param totalPremium The total premium
     */
    public Quote(Person insuredPerson, double totalPremium) {
        this.insuredPerson = insuredPerson;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now().plusDays(30);
        this.totalPremium = totalPremium;
    }

    /**
     * Gets the start date of the Quote object
     * @return startDate A date object representing the start date of a Quote object
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the end date of the Quote object
     * @return endDate A date object representing the end date of a Quote object
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Gets the total premium value of the Quote object
     * @return totalPremium The totalPremium of the Quote object
     */
    public double getTotalPremium() {
        return totalPremium;
    }

    /**
     * Gets the driver object of the Quote object
     * @return driver A Person object representing a quote's driver
     */
    public Person getInsuredPerson() {
        return insuredPerson;
    }
}
