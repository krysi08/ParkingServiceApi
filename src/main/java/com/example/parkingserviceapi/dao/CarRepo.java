package com.example.parkingserviceapi.dao;

import com.example.parkingserviceapi.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {


}
