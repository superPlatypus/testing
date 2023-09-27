package com.example.course.controllers;

import com.example.course.entity.Role;
import com.example.course.entity.User;
import com.example.course.repository.UserRepo;
import com.example.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userSevice;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

//    @PostMapping("/registration")
//    public String addUser(User user, Map<String, Object> model) {
//        User userFromDb = userRepo.findByUsername(user.getUsername());
//
//        if (userFromDb != null) {
//            model.put("message", "User exists!");
//            return "registration";
//        }
//
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
////        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepo.save(user);
//
//        return "redirect:/login";
//    }

    @PostMapping("/registration")
    public String registration(User user, Model model){
        if (!userSevice.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }
}
