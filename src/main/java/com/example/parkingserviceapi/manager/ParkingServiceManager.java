package com.example.parkingserviceapi.manager;

import com.example.parkingserviceapi.color.Color;
import com.example.parkingserviceapi.entity.Car;
import com.example.parkingserviceapi.dao.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingServiceManager {

    private CarRepo carRepo;

    @Autowired
    public ParkingServiceManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public ParkingServiceManager() {

    }

    public Optional<Car> findById(Long id)
    {
        return carRepo.findById(id);
    }

    public Iterable<Car> findAll()
    {
        return carRepo.findAll();
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