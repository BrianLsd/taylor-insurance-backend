package com.example.capstone.POJOS.testers;

import com.example.capstone.POJOS.*;

public class tester {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setAge(31);
        driver.setAddress("1234 Main St");
        driver.setNumberAccidents(0);

        Vehicle vehicle = new Vehicle();
        vehicle.setYear(2023);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");

        AutoQuote autoQuote = AutoQuoteFactory.createAutoQuote(vehicle, driver);
        System.out.println(autoQuote.getTotalPremium());
    }
}
