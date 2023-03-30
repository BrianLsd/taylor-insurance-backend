package com.example.capstone.POJOS;

/**
 * Takes in Home attributes and returns the corresponding home risk factors
 */
public class HomeRiskRates {
    private HomeRiskRates(){}

    /**
     * returns the base premium value
     * @return 500 Base Premium for Home
     */
    public static double getPremium(){
        return 500;
    }

    /**
     * returns the tax rate value
     * @return 1.15 Tax Rate
     */
    public static double getTax(){
        return 1.15;
    }

    /**
     * return the home value factor
     * @param homeValue Home Value
     * @return 0.002 * (homeValue - 250000) or 0 Home Value Factor
     */
    public static double getHomeValueFactor(double homeValue){
        if (homeValue > 250000){
            return 0.002 * (homeValue - 250000);
        } else {
            return 0;
        }
    }

    /**
     * returns the home age factor
     * @param homeAge Age of Home
     * @return 1, 1.25, or 1.5 Home Age Factor
     */
    public static double getHomeAgeFactor(double homeAge){
        if (homeAge > 50){
            return 1.5;
        } else if (homeAge > 25){
            return 1.25;
        } else {
            return 1;
        }
    }

    /**
     * returns the home heating type factor
     * @param homeHeatingType Home Heating Type
     * @return 1, 1.25, or 2 Home Heating Type factor
     */
    public static double getHeatingFactor(HeatingType homeHeatingType){
        switch (homeHeatingType) {
            case ELECTRIC, GAS, OTHER -> {
                return 1;
            }
            case WOOD -> {
                return 1.25;
            }
            case OIL -> {
                return 2;
            }
            default -> throw new IllegalArgumentException("Invalid Heating Type");
        }
    }

    /**
     * returns the home location factor
     * @param homelocation Home Location
     * @return 1 or 1.15 Home Location Factor
     */
    public static double getLocationFactor(Location homelocation){
        switch (homelocation){
            case URBAN -> {
                return 1;
            }
            case RURAL -> {
                return 1.15;
            }
            default -> throw new IllegalArgumentException("Invalid Location Type");
        }
    }
}
