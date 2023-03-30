package com.example.capstone.POJOS;

/**
 * Instantiate examples of Driver, Vehicle, AutoQuote, AutoPolicy,
 * HomeOwner, Home, HomeQuote, and HomePolicy objects.
 */
public class Tester {

    public static void main(String[] args) {

        // example persons
        Driver person1 = new Driver(19, "1 A St., St.John's", 0);
        Driver person2 = new Driver(26, "1 B St., St.John's", 3);

        // example cars
        Vehicle car1 = new Vehicle(2020, "Model 3", "Tesla");
        Vehicle car2 = new Vehicle(2010, "Model S", "Tesla");

        // Auto Quotes and Policies
        System.out.println("1. Auto");

        // create autoQuote1
        AutoQuote autoQuote1 = AutoQuoteFactory.createAutoQuote(car1, person1);
        // print
        System.out.println("\n\tQuote 1");
        System.out.printf("Total Premium: %.2f\n", autoQuote1.getTotalPremium());
        System.out.println("Start Date: " + autoQuote1.getStartDate());
        System.out.println("End Date: " + autoQuote1.getEndDate());
        System.out.println("Tax: " + autoQuote1.getTax());
        System.out.println("Base Premium: " + autoQuote1.getBasePremium());

        // create autoPolicy1
        AutoPolicy autoPolicy1 = AutoPolicyFactory.createAutoPolicy(autoQuote1);
        // print
        System.out.println("\tPolicy 1");
        System.out.println("Start Date: " + autoPolicy1.getStartDate());
        System.out.println("End Date: " + autoPolicy1.getEndDate());

        // create autoQuote2
        AutoQuote autoQuote2 = AutoQuoteFactory.createAutoQuote(car1, person2);
        // print
        System.out.println("\n\tQuote 2");
        System.out.printf("Total Premium: %.2f\n", autoQuote2.getTotalPremium());
        System.out.println("Start Date: " + autoQuote2.getStartDate());
        System.out.println("End Date: " + autoQuote2.getEndDate());
        System.out.println("Tax: " + autoQuote2.getTax());
        System.out.println("Base Premium: " + autoQuote2.getBasePremium());

        // create autoPolicy2
        AutoPolicy autoPolicy2 = AutoPolicyFactory.createAutoPolicy(autoQuote2);
        // print
        System.out.println("\tPolicy 2");
        System.out.println("Start Date: " + autoPolicy2.getStartDate());
        System.out.println("End Date: " + autoPolicy2.getEndDate());

        // create autoQuote3
        AutoQuote autoQuote3 = AutoQuoteFactory.createAutoQuote(car2, person1);
        // print
        System.out.println("\n\tQuote 3");
        System.out.printf("Total Premium: %.2f\n", autoQuote3.getTotalPremium());
        System.out.println("Start Date: " + autoQuote3.getStartDate());
        System.out.println("End Date: " + autoQuote3.getEndDate());
        System.out.println("Tax: " + autoQuote3.getTax());
        System.out.println("Base Premium: " + autoQuote3.getBasePremium());

        // create autoPolicy3
        AutoPolicy autoPolicy3 = AutoPolicyFactory.createAutoPolicy(autoQuote3);
        // print
        System.out.println("\tPolicy 3");
        System.out.println("Start Date: " + autoPolicy3.getStartDate());
        System.out.println("End Date: " + autoPolicy3.getEndDate());

        // create autoQuote4
        AutoQuote autoQuote4 = AutoQuoteFactory.createAutoQuote(car2, person2);
        // print
        System.out.println("\n\tQuote 4");
        System.out.printf("Total Premium: %.2f\n", autoQuote4.getTotalPremium());
        System.out.println("Start Date: " + autoQuote4.getStartDate());
        System.out.println("End Date: " + autoQuote4.getEndDate());
        System.out.println("Tax: " + autoQuote4.getTax());
        System.out.println("Base Premium: " + autoQuote4.getBasePremium());

        // create autoPolicy4
        AutoPolicy autoPolicy4 = AutoPolicyFactory.createAutoPolicy(autoQuote4);
        // print
        System.out.println("\tPolicy 4");
        System.out.println("Start Date: " + autoPolicy4.getStartDate());
        System.out.println("End Date: " + autoPolicy4.getEndDate());

        // Home Quotes and Policies
        System.out.println("\n2. Home");

        // example homeowner
        HomeOwner homeOwner = new HomeOwner(23, "2 B st, Toronto");

        // example homes
        Home home1 = new Home(20, DwellingType.SINGLE, HeatingType.ELECTRIC, Location.URBAN, 200000);
        Home home2 = new Home(30, DwellingType.APARTMENT, HeatingType.WOOD, Location.RURAL, 200000);
        Home home3 = new Home(60, DwellingType.SEMI_ATTACHED, HeatingType.OIL, Location.RURAL, 500000);

        // create homeQuote1
        HomeQuote homeQuote1 = HomeQuoteFactory.createHomeQuote(home1, homeOwner);
        // print
        System.out.println("\n\tQuote 1");
        System.out.printf("Total Premium: %.2f\n", homeQuote1.getTotalPremium());

        // create homePolicy1
        HomePolicy homePolicy1 = HomePolicyFactory.createHomePolicy(homeQuote1);
        // print
        System.out.println("\tPolicy 1");
        System.out.println("Start Date: " + homePolicy1.getStartDate());
        System.out.println("End Date: " + homePolicy1.getEndDate());

        // create homeQuote2
        HomeQuote homeQuote2 = HomeQuoteFactory.createHomeQuote(home2, homeOwner);
        // print
        System.out.println("\n\tQuote 2");
        System.out.printf("Total Premium: %.2f\n", homeQuote2.getTotalPremium());

        // create homePolicy2
        HomePolicy homePolicy2 = HomePolicyFactory.createHomePolicy(homeQuote2);
        // print
        System.out.println("\tPolicy 2");
        System.out.println("Start Date: " + homePolicy2.getStartDate());
        System.out.println("End Date: " + homePolicy2.getEndDate());

        // create homeQuote3
        HomeQuote homeQuote3 = HomeQuoteFactory.createHomeQuote(home3, homeOwner);
        // print
        System.out.println("\n\tQuote 3");
        System.out.printf("Total Premium: %.2f\n", homeQuote3.getTotalPremium());

        // create homePolicy3
        HomePolicy homePolicy3 = HomePolicyFactory.createHomePolicy(homeQuote3);
        // print
        System.out.println("\tPolicy 3");
        System.out.println("Start Date: " + homePolicy3.getStartDate());
        System.out.println("End Date: " + homePolicy3.getEndDate());
    }
}
