package com.example.parkingserviceapi.dao;

import com.example.parkingserviceapi.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<Car,Long> {
}
