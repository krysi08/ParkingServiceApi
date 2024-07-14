package com.example.parkingserviceapi.entity;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    List<List<Slot>> slots;

    ParkingLot(String parkingLotId, int nfloors, int noOfSlotsPerFlr) {
        this.parkingLotId = parkingLotId;

        slots = new ArrayList<>();
        for (int i = 0; i < nfloors; i++) {
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("motorbike"));
            floorSlots.add(new Slot("motorbike"));
            floorSlots.add(new Slot("bus"));
            floorSlots.add(new Slot("bus"));
            floorSlots.add(new Slot("coach"));

            for (int j = 5; j < noOfSlotsPerFlr; j++) {
                slots.get(i).add(new Slot("car"));
            }
        }
    }
    public String parkVehicle(String type, String regNo, String color) {
        Vehicle vehicle = new Vehicle(type, regNo, color);

        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.type == type && slot.vehicle == null) {
                    slot.vehicle=vehicle;
                    slot.ticketId=generateTicketId(i+1, j+1);
                    return slot.ticketId;
                }
            }
        }
        System.out.println("NO slot available for given type");
        return null;
        }
        private String generateTicketId(int flr, int slno){
            return parkingLotId + "_" + flr + "_" + slno;
    }
    public void unPark(String ticketId){
        String[] extract = ticketId.split("_");
        int flr_idx=Integer.parseInt(extract[1])-1;
        int slot_idx=Integer.parseInt(extract[2])-1;

        for(int i=0; i<slots.size();i++){
            for(int j=0;j<slots.get(i).size(); j++){
                if(i==flr_idx && j==slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    slot.vehicle=null;
                    slot.ticketId=null;
                    System.out.println("Unparked vehicle");
                }
            }
        }
    }
    int getNoOfOpenSlots(String type){
        int count=0;
        for(List<Slot> floor: slots){
            for(Slot slot: floor){
                if(slot.vehicle == null && slot.type.equals(type)) count++;
            }
        }
        return count;
    }
    void displayOpenSlots(String type){
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.vehicle == null && slot.type.equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }
    void displayOccupiedSlots(String type){
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.vehicle != null && slot.type.equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }
}












