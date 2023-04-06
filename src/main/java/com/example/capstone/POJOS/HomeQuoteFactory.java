package com.example.capstone.POJOS;

/**
 * Factory class, create HomeQuote objects
 */
public class HomeQuoteFactory{
    private HomeQuoteFactory(){}

    /**
     * Static method - Takes in home and homeOwner objects, then create and return an HomeQuote
     * object based on the attribute come with the home and homeOwner
     * @param home Home Object
     * @param homeOwner HomeOwner Object
     * @return HomeQuote HomeQuote Object
     */
    public static HomeQuote createHomeQuote(Home home, HomeOwner homeOwner){
        double totalPremium = (HomeRiskRates.getPremium() + HomeRiskRates.getHomeValueFactor(home.getValue())) *  HomeRiskRates.getHomeAgeFactor(home.getDateBuilt())
                * HomeRiskRates.getHeatingFactor(home.getHeatingType()) * HomeRiskRates.getLocationFactor(home.getLocation()) * HomeRiskRates.getTax();
        return new HomeQuote.Builder(homeOwner, home, 2000000, 1000, 50000, 500,
                HomeRiskRates.getPremium(), HomeRiskRates.getTax(), totalPremium).build();
    }
}