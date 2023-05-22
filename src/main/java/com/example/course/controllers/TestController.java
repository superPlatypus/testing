package com.example.course.controllers;

import com.example.course.entity.Car;
import com.example.course.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @Autowired
    private CarRepo carRepo;
//    @GetMapping("/")
//    public String init(Model model){
//        return "init";
//    }
    @GetMapping("/")
    public String home(Model model){
        return "home";
    }
}