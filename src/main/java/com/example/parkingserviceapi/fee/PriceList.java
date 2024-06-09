package com.example.parkingserviceapi.fee;

public class PriceList {

    public void settleCostsParking(double timeParking) {
        if (timeParking >= MINIMUM_PARKING_TIME_IN_MINUTES && timeParking <= MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT) {
            System.out.println("Please pay off 5EUR");
        } else if (timeParking > MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT && timeParking <= MAXIMUM_PARKING_TIME_IN_MINUTES) {
            double valueCosts = timeParking * PRICE_FEE / MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT;
            System.out.println("You have to pay off" + " " + valueCosts + " " + "EUR");
        } else if (timeParking > MAXIMUM_PARKING_TIME_IN_MINUTES) {
            double discountCosts = (timeParking * DISCOUNT_FEE) /MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT;
            System.out.println("You have to pay off" + " " + discountCosts + " " + "EUR");
        } else {
            System.out.println("No fees");
        }
    }

    static int MINIMUM_PARKING_TIME_IN_MINUTES = 10;
    static int MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT = 60;
    static int MAXIMUM_PARKING_TIME_IN_MINUTES = 240;
    static int PRICE_FEE = 5;
    static int DISCOUNT_FEE = 4;
}