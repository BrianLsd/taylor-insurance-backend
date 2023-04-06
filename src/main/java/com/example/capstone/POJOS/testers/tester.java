package com.example.capstone.POJOS.testers;

import com.example.capstone.POJOS.*;

import java.time.LocalDate;

public class tester {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setYear(2020);
        vehicle.setMake("Model 3");
        vehicle.setModel("Tesla");

        Driver person = new Driver(19, "123 Main st", 0);

        AutoQuote autoQuote = AutoQuoteFactory.createAutoQuote(vehicle, person);
        System.out.println("\n\tQuote 1");
        System.out.printf("Total Premium: %.2f\n", autoQuote.getTotalPremium());
        System.out.println("Start Date: " + autoQuote.getStartDate());
        System.out.println("End Date: " + autoQuote.getEndDate());
        System.out.println("Tax: " + autoQuote.getTax());
        System.out.println("Base Premium: " + autoQuote.getBasePremium());

        Home home = new Home();
        home.setDateBuilt(LocalDate.of(2003,1,1));
        home.setValue(200000);
        home.setDwellingType(DwellingType.SINGLE);
        home.setHeatingType(HeatingType.ELECTRIC);
        home.setLocation(Location.URBAN);

        HomeOwner person2 = new HomeOwner(23, "123 Main st");

        HomeQuote homeQuote = HomeQuoteFactory.createHomeQuote(home, person2);
        System.out.println("\n\tQuote 1");
        System.out.printf("Total Premium: %.2f\n", homeQuote.getTotalPremium());
    }
}
