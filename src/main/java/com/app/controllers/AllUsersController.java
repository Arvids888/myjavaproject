package com.app.controllers;

import com.app.services.NoteService;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllUsersController {
    @Autowired
    private NoteService userService;

    @GetMapping("/allusers")
    public String getAllUsersPage(Model model) {
        model.addAttribute("allusers", userService.getUsers());
        return "allusers";
    }
}
