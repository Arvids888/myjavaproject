//package com.app.controllers;
//
//import com.app.services.UserService;
//import model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class SuccessController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/successRegistration")
//    public String showSuccessPage(User user, Model model) {
//        model.addAttribute("firstName", userService.validateUser(user).getFirstName());
//        return "successRegistration";
//    }
//}
