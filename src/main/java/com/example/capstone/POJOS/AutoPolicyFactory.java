package com.example.capstone.POJOS;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Factory class, create AutoPolicy objects
 */
public class AutoPolicyFactory {
    private AutoPolicyFactory(){}

    /**
     * Takes in an autoQuote object then create an AutoPolicy object based on the attributes come with the quote
     * @param autoQuote Auto Quote
     * @return autoPolicy Auto Policy
     */
    public static AutoPolicy createAutoPolicy(AutoQuote autoQuote){
        return new AutoPolicy.Builder(autoQuote.getInsuredPerson(), autoQuote.getVehicle(), autoQuote.getLiabilityLimit(),
                autoQuote.getDeductible(), autoQuote.getBasePremium(), autoQuote.getTax(), autoQuote.getTotalPremium()).build();
    }

    /**
     * Takes in an autoPolicy object, and checks the end date on the policy
     * if the end date is within 60 days, create a new policy. Otherwise, return
     * the original policy object and inform user
     * @param autoPolicy Auto Policy
     * @return autoPolicy Auto Policy
     */
    public static AutoPolicy renewAutoPolicy(AutoPolicy autoPolicy){
        if (ChronoUnit.DAYS.between(LocalDate.now(), autoPolicy.getEndDate()) <= 60){
            return new AutoPolicy.Builder(autoPolicy.getDriver(), autoPolicy.getVehicle(), autoPolicy.getLiabilityLimit(),
                    autoPolicy.getDeductible(), autoPolicy.getBasePremium(), autoPolicy.getTax(), autoPolicy.getTotalPremium()).build();
        } else {
            return autoPolicy;
        }
    }
}

