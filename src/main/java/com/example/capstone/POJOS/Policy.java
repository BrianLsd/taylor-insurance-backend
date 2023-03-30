package com.example.capstone.POJOS;

import java.time.LocalDate;

/**
 * An abstract class to be extended by concrete policy classes
 */
public abstract class Policy {
    private final Person insuredPerson;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double totalPremium;

    /**
     * A constructor to create Policy objects
     * @param insuredPerson The insured person object
     * @param totalPremium The total premium
     */
    public Policy(Person insuredPerson, double totalPremium) {
        this.insuredPerson = insuredPerson;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now().plusYears(1);
        this.totalPremium = totalPremium;
    }

    /**
     * Gets the insured person object of the Policy object
     * @return insuredPerson A Person object representing a policy's insured person
     */
    public Person getInsuredPerson() {
        return insuredPerson;
    }

    /**
     * Gets the start date of the Policy object
     * @return startDate A date object representing the start date of a Policy object
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the end date of the Policy object
     * @return endDate A date object representing the end date of a Policy object
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Gets the total premium value of the Policy object
     * @return totalPremium The total premium of the Policy object
     */
    public double getTotalPremium() {
        return totalPremium;
    }
}
