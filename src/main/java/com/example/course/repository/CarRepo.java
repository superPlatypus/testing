package com.example.course.repository;

import com.example.course.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car, Long> {
    public void deleteCarById(Integer id);
}
