package com.example.course.service;

import com.example.course.entity.Car;
import com.example.course.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    CarRepo carRepo;

    public boolean addCar(Car car){
        carRepo.save(car);
        return true;
    }

    public boolean editCar(Car car, String name, double price){
        car.setName(name);
        car.setPrice(price);
        carRepo.save(car);
        return true;
    }

    public boolean deleteCar(Car car){
        carRepo.delete(car);
        return true;
    }
}
