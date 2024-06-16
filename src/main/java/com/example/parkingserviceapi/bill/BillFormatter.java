package com.example.parkingserviceapi.bill;

import java.util.Formatter;

public class BillFormatter {

    private double sum = 0;
    private Formatter f = new Formatter(System.out);
    public void Title() {
        f.format("%-15s %5s %10s/n","ID","time", "price");
        f.format("%-15s %5s %10s/n","","" ,"");
    }
    public void TitleCars(int id, int time, double price) {
        f.format("%-15s %5s %10s/n",id,time,price);
        sum += price;
    }

    public void returnSum() {
      f.format("%-15s %5s %10s/n","tax", sum*0.22);
      f.format("%-15s %5s %10s/n","","" ,"");
      f.format("%-15s %5s %10s/n","sum","", sum*1.22);
    }
}
