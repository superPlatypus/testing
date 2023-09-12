package com.example.course.controllers;

import com.example.course.entity.Car;
import com.example.course.entity.CarOrder;
import com.example.course.entity.User;
import com.example.course.repository.CarOrderRepo;
import com.example.course.repository.CarRepo;
import com.example.course.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

/**
 * Класс контроллера аренды автомобиля.
 * @autor Кирилл Пашовкин
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    CarOrderRepo orderRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CarRepo carRepo;
    private CarOrder newOrder = new CarOrder();

    @GetMapping
    public String order(Model model){
        model.addAttribute("cars", carRepo.findAll());
        return "order";
    }

    @GetMapping("{car}")
    public String orderCar(@PathVariable Car car,
                           Model model,
                           @AuthenticationPrincipal User user){
        model.addAttribute("car", car);
        return "orderCar";

    }

    @PostMapping("{car}/start")
    public String startOrder(@PathVariable Car car){
        newOrder.setStart(LocalDateTime.now());
        newOrder.setOrderedCar(car);
        System.out.println(LocalDateTime.now());
        return "orderCar";
    }

    @PostMapping("{car}/finish")
    public String finishOrder(@PathVariable Car car,
                              @AuthenticationPrincipal User user){
        newOrder.setFinish(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
//        newOrder.setOrderedCar(car);
//        newOrder.setPrice(Duration.between(newOrder.getStart(), newOrder.getFinish()).toMinutes() * car.getPrice());
        newOrder.setPrice(Duration.between(newOrder.getStart(), newOrder.getFinish()).toSeconds() * car.getPrice());
        user.addOrder(newOrder);

        orderRepo.save(newOrder);
        userRepo.save(user);
        System.out.println(Arrays.toString(user.getOrders().toArray()));
        return "redirect:/order";
    }
}
