package com.example.course.controllers;

import com.example.course.entity.User;
import com.example.course.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String profile(@AuthenticationPrincipal User user,
                          Model model){
        model.addAttribute("user", user);
        model.addAttribute("orders", user.getOrders());

        return "profile";
    }
}
