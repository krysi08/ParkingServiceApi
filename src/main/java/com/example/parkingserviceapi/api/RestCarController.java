package com.example.parkingserviceapi.api;

import com.example.parkingserviceapi.entity.Car;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/car")
public class RestCarController {


    private List<Car> Carlist;


    public RestCarController() {
        Carlist = new ArrayList<>();
    }

    @GetMapping("/all")
    public List<Car> getAll() {
        return Carlist;
    }

    @GetMapping
    public Car getById(@RequestParam int index) {
       Optional<Car> firstcar = Carlist.stream().
               filter(ind -> ind.getId() == index).findFirst();
       return firstcar.get();
    }

    @PostMapping
    public boolean addCar(@RequestBody Car car) {
        return Carlist.add(car);
    }

    @PutMapping
    public boolean updateCar(@RequestBody Car car) {
        return Carlist.add(car);
    }

    @DeleteMapping
    public boolean deleteCar(@RequestParam int index) {
       return Carlist.removeIf(ind -> ind.getId() == index);
    }
}
