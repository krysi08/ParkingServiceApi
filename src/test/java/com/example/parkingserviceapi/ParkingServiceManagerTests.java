package com.example.parkingserviceapi;

import com.example.parkingserviceapi.color.Color;
import com.example.parkingserviceapi.entity.Car;
import com.example.parkingserviceapi.manager.ParkingServiceManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.BDDMockito;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParkingServiceManagerTests {

//    test

    @Test
    public void should_findAll() {
        ParkingServiceManager parkingServiceManager = mock(ParkingServiceManager.class);
        when(parkingServiceManager.findAll()).thenReturn(DBtoMock());

        List<Car> cars = parkingServiceManager.findAll();

        assertThat(cars).hasSize(2);
    }


    @Test
    public void should_findAll_list_does_not_exist() {
        ParkingServiceManager parkingServiceManager = mock(ParkingServiceManager.class);

        when(parkingServiceManager.findAll()).thenReturn(List.of());

        List<Car> cars = parkingServiceManager.findAll();

        assertThat(cars).hasSize(0);
    }

    @Test
    public void should_findAll_by_Id() {
        ParkingServiceManager parkingServiceManager = mock(ParkingServiceManager.class);

        Car car = new Car(1L,"1A","Opel","Insignia", Color.BLACK);

        when(parkingServiceManager.findById(1L)).thenReturn(List.of(car));
        List<Car> result = parkingServiceManager.findById(1L);

        assertEquals(1L, result.get(0).getId());
        assertEquals("1A", result.get(0).getIDname());
        assertEquals("Opel", result.get(0).getModel());
        assertEquals("Insignia", result.get(0).getManufacture());
        assertEquals(Color.BLACK, result.get(0).getColor());

    }
    @Test
    public void should_findAll_by_Id_car_does_not_exist() {

        ParkingServiceManager parkingServiceManager = mock(ParkingServiceManager.class);

        Car car1 = new Car();

        when(parkingServiceManager.findById(1L)).thenReturn(List.of(car1));

        List<Car> result = parkingServiceManager.findById(1L);

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void should_save_cars() {
        ParkingServiceManager parkingServiceManager = mock(ParkingServiceManager.class);
        BDDMockito.given(parkingServiceManager.save(Mockito.any(Car.class))).willReturn(new Car("1A","Opel","Insignia", Color.BLACK));

        Car car = parkingServiceManager.save(new Car());

        assertEquals(car.getIDname(),"1A");
        assertEquals(car.getModel(),"Opel");
        assertEquals(car.getManufacture(),"Insignia");
        assertEquals(car.getColor(),Color.BLACK);
    }


    private List<Car> DBtoMock()
    {
        List<Car> cars = new ArrayList<>();
        cars.add((new Car(1L,"1A","Opel","Insignia", Color.BLACK)));
        cars.add((new Car(2L,"1B","BMW","5",Color.WHITE)));
        return cars;
    }
}