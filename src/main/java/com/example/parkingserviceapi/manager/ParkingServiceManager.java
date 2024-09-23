package com.example.parkingserviceapi.manager;

import com.example.parkingserviceapi.color.Color;
import com.example.parkingserviceapi.dao.CarRepo;
import com.example.parkingserviceapi.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServiceManager {

    private CarRepo carRepo;

    @Autowired
    public ParkingServiceManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public List<Car> findById(Long id)
    {
        List<Car> cars = new ArrayList<>();
                carRepo.findById(id).ifPresent(cars::add);
        return cars;
    }

    public List<Car> findAll()
    {
        List<Car> cars2 = new ArrayList<>();
        carRepo.findAll().iterator().forEachRemaining(cars2::add);
        return cars2;
    }

    public Car save(Car car)
    {
        return carRepo.save(car);
    }

    public void deletebyId(Long id) {
    carRepo.deleteById(id);
    }


@EventListener(ApplicationReadyEvent.class)
    public void addDB()
    {
        save((new Car("1A","Opel","Insignia", Color.BLACK)));
        save((new Car("1B","BMW","5",Color.WHITE)));
    }
}