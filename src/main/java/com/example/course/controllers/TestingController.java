package com.example.course.controllers;

import com.example.course.entity.Car;
import com.example.course.repository.CarRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("testing")
public class TestingController {
    @Autowired
    CarRepo carRepo;
//    @GetMapping
//    @ResponseBody
//    public String currentUserNameSimple(HttpServletRequest request) {
//        Principal principal = request.getUserPrincipal();
//        return principal.getName();
//    }

    @GetMapping("/getAllCars")
    public Iterable<Car> test() {
        Iterable<Car> cars = carRepo.findAll();
        return cars;
    }


}
