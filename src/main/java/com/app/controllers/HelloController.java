package com.app.controllers;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
    @GetMapping("/registration") // http://localhost:8080/hello/Notes
    public String getHelloPage(Model model) {
        model.addAttribute("userData", new User());
        return "registration";

    }

    @PostMapping("/registration")
    public String siteRegister(@ModelAttribute User user, Model model) {
        model.addAttribute("firstName", user.getFirstName());
        return "successRegistration";
    }
}
