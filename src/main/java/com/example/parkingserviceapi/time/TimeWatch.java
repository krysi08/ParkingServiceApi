package com.example.parkingserviceapi.time;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class TimeWatch {
    private Date startTime;
    private Date stopTime;
    private boolean running = false;


    public void start() {
        this.startTime = Calendar.getInstance().getTime();
        this.running = true;
        System.out.println("Parking time starts at: " + this.startTime);
    }

    public void stop() {
        this.stopTime = Calendar.getInstance().getTime();
        this.running = false;
        System.out.println("Parking time was stopped at: " + this.stopTime);
    }

    public void settleVariance() {

        Instant instant1 = Instant.parse(startTime.toString());
        Instant instant2 = Instant.parse(stopTime.toString());

        Duration duration = Duration.between(instant1, instant2);

        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
    }
}

