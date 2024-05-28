package com.example.parkingserviceapi.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


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
}
/*
 not resolved problem how to convert Date to int yet
    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((running - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }
*/
