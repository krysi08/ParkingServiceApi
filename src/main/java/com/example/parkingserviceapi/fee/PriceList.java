package com.example.parkingserviceapi.fee;

public class PriceList {

    public double settleCostsParking(double timeParking) {
        if (timeParking >= MINIMUM_PARKING_TIME_IN_MINUTES && timeParking <= MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT) {
            return 5;
        } else if (timeParking > MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT && timeParking <= MAXIMUM_PARKING_TIME_IN_MINUTES) {
            double valueCosts = timeParking * PRICE_FEE / MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT;
            return valueCosts;
        } else if (timeParking > MAXIMUM_PARKING_TIME_IN_MINUTES) {
            double discountCosts = (timeParking * DISCOUNT_FEE) / MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT;
            return discountCosts;
        }
        return 0;
    }

    static int MINIMUM_PARKING_TIME_IN_MINUTES = 10;
    static int MAXIMUM_PARKING_TIME_IN_MINUTES_DISCOUNT = 60;
    static int MAXIMUM_PARKING_TIME_IN_MINUTES = 240;
    static int PRICE_FEE = 5;
    static int DISCOUNT_FEE = 4;
}