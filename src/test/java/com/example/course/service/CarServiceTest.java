package com.example.course.service;

import com.example.course.entity.Car;
import com.example.course.entity.User;
import com.example.course.repository.CarRepo;
import com.example.course.repository.UserRepo;
import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
    @Autowired
    private CarService carService;
    @MockBean
    private CarRepo carRepo;
    @Test
    public void addCar() {
        Car car = new Car();
        boolean isCarCreated = carService.addCar(car);
        Assert.assertTrue(isCarCreated);
        verify(carRepo, times(1)).save(car);
    }

    @Test
    public void editCar() {
        Car car = new Car();
        String newName = "newName";
        double newPrice = 10d;
        boolean isEdited = carService.editCar(car, newName, newPrice);
        Assert.assertTrue(isEdited);
        verify(carRepo, times(1)).save(car);
    }

    @Test
    public void deleteCar() {
        Car carToDelete = new Car();
        doNothing().when(carRepo).delete(carToDelete);
        boolean isDeleted =  carService.deleteCar(carToDelete);
        verify(carRepo, times(1)).delete(carToDelete);
    }
}