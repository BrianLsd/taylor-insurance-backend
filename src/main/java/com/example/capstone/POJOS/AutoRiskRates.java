package com.example.capstone.POJOS;

import java.time.Year;

/**
 * Takes in Driver and Vehicle attributes and returns the corresponding auto risk factors
 */
public class AutoRiskRates {
    private AutoRiskRates(){}

    /**
     * returns the base premium value
     * @return 750 Base Premium for Auto
     */
    public static double getPremium(){
        return 750;
    }

    /**
     * returns the tax rate value
     * @return 1.15 Tax Rate
     */
    public static double getTax(){
        return 1.15;
    }

    /**
     * returns the age risk factor
     * @param driverAge Age of Driver
     * @return 1 or 2 Age Risk Factor
     */
    public static double getDriverAgeFactor(double driverAge){
        if (driverAge >= 25){
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * returns the accident risk factor
     * @param driverAccidents Number of Accidents
     * @return 1, 1.25, or 2.5 Accident risk rate
     */
    public static double getAccidentsFactor(int driverAccidents){
        if (driverAccidents > 2){
            return 2.5;
        } else if (driverAccidents > 1){
            return 1.25;
        } else {
            return 1;
        }
    }

    /**
     * returns the vehicle age risk factor
     * @param vehicleYear Year of the vehicle was made
     * @return 1, 1.5, or 2 Vehicle Age Risk Factor
     */
    public static double getVehicleAgeFactor(int vehicleYear){
        if (Year.now().minusYears(vehicleYear).getValue() > 10 ){
            return 2;
        } else if (Year.now().minusYears(vehicleYear).getValue() > 5){
            return 1.5;
        } else {
            return 1;
        }
    }
}
