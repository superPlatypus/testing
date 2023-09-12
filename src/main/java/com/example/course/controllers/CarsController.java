package com.example.course.controllers;

import com.example.course.entity.Car;
import com.example.course.entity.Role;
import com.example.course.entity.User;
import com.example.course.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
//@PreAuthorize("hasAuthority('ADMIN')")
public class CarsController {
    @Autowired
    CarRepo carRepo;


    @GetMapping
    public String showCars(Model model,
                           @AuthenticationPrincipal User user){

        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("{car}")
    public String carForm(@PathVariable Car car, Model model){
        model.addAttribute("car", car);
        return "carEditt";

    }

    @PostMapping("{car}/delete")
    public String carDelete(@PathVariable Car car, Model model){
        carRepo.delete(car);
        System.out.println(car.getName() + car.getId());
        model.addAttribute("cars", carRepo.findAll());

        return "redirect:/cars";
    }

    @PostMapping("{car}/edit")
    public String carEdit(@PathVariable Car car,
                              @RequestParam String name,
                              @RequestParam double price,
                              Model model){
        car.setName(name);
        car.setPrice(price);
        carRepo.save(car);
        System.out.println(car.getName() + car.getId());
        return "redirect:/cars";
    }

    @PostMapping
    public String addCar(@RequestParam String name, @RequestParam double price, Model model){
        Car car = new Car(name, price);

        carRepo.save(car);

        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);

        return "cars";
    }

//    @PostMapping()
//    public String deleteCar(@RequestParam("carId") Car car,
//                            Model model){
//        carRepo.delete(car);
//        model.addAttribute("cars", carRepo.findAll());
//        return "cars";
//
//    }
}
