package com.app.controllers;

import com.app.Business;
import com.app.services.Note;
import com.app.services.User;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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
