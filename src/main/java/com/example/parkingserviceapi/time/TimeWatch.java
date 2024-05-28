package com.example.parkingserviceapi.time;



public class TimeWatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;


    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
        System.out.println("The time has been started");
    }


    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
        System.out.println("Parking time has been stopped");
    }

    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }

    public static void main(String[] args) {
        TimeWatch tw = new TimeWatch();
        tw.start();
        tw.stop();
        tw.getElapsedTimeSecs();
    }
}