package com.example.capstone.POJOS;

import java.text.DecimalFormat;

/**
 * Factory class, create AutoQuote objects
 */
public class AutoQuoteFactory{
    private AutoQuoteFactory(){}

    /**
     * Static method - Takes in vehicle and driver objects, then create and return an AutoQuote
     * object based on the attribute come with the vehicle and driver
     * @param vehicle Vehicle Object
     * @param driver Driver Object
     * @return AutoQuote AutoQuote Object
     */
    public static AutoQuote createAutoQuote(Vehicle vehicle, Driver driver){
        double totalPremium = AutoRiskRates.getPremium() * AutoRiskRates.getDriverAgeFactor(driver.getAge()) *
                AutoRiskRates.getAccidentsFactor(driver.getNumberAccidents()) * AutoRiskRates.getVehicleAgeFactor(vehicle.getYear())
                * AutoRiskRates.getTax();
        DecimalFormat df = new DecimalFormat("#.##");
        totalPremium = Double.parseDouble(df.format(totalPremium));
        return new AutoQuote.Builder(driver, vehicle, 1000000, 500, AutoRiskRates.getPremium(),
                AutoRiskRates.getTax(), totalPremium).build();
    }
}