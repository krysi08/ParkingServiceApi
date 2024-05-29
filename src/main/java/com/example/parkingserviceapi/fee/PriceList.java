package com.example.parkingserviceapi.fee;

import com.example.parkingserviceapi.time.TimeWatch;

import java.util.Timer;

public class PriceList  {

    public static void main(String[] args) {

        PriceList list = new PriceList();
    }

    public void settleCostsParking(double timeParking) {
        if (timeParking >= 10 && timeParking <= 60) {
            System.out.println("Please pay off 5EUR");
        } else if (timeParking > 60 && timeParking <= 240) {
            double valueCosts = timeParking * 5 / 60;
            System.out.println("You have to pay off" + " " + valueCosts + " " + "EUR");
        } else if (timeParking > 240) {
            double discountCosts = (timeParking * 4) / 60;
            System.out.println("You have to pay off" + " " + discountCosts + " " + "EUR");
        } else {
            System.out.println("No fees");
        }
    }
}