package com.example.parkingserviceapi;

import com.example.parkingserviceapi.color.Color;
import com.example.parkingserviceapi.entity.Car;
import com.example.parkingserviceapi.manager.ParkingServiceManager;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParkingServiceTest {

    // Check out to make it work:
    // https://www.baeldung.com/spring-testing-separate-data-source -> You need test repository here
    private final ParkingServiceManager parkingServiceManager = new ParkingServiceManager();

    @Test
    public void shouldAddSingleCar() {
        // given
        Car car = new Car("123", "Corsa", "Opel", Color.WHITE);

        // when
        parkingServiceManager.save(car);

        // then
        List<Car> cars = new ArrayList<>();
        parkingServiceManager.findAll().forEach(cars::add);
        assertEquals(cars.size(), 1);
        assertEquals(cars.get(0).getColor(), Color.WHITE);
        assertEquals(cars.get(0).getIDname(), "123");
        assertEquals(cars.get(0).getManufacture(), "Opel");
        assertEquals(cars.get(0).getModel(), "Corsa");
    }

    @Test
    public void removeCar() {

        Car car1 = new Car("456", "5", "BMW", Color.BLACK);

        parkingServiceManager.deletebyId(car1.getId());

        List<Car> cars1 = new ArrayList<>();
        parkingServiceManager.findAll().forEach(cars1::remove);
        assertEquals(cars1.size(), 0);
        assertEquals(cars1.get(0).getColor(), null);
        assertEquals(cars1.get(0).getIDname(), null);
        assertEquals(cars1.get(0).getManufacture(), null);
        assertEquals(cars1.get(0).getModel(), null);

    }
}