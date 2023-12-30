package com.app.controllers;

import com.app.services.NoteService;
import model.Category;
import model.Note;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @Autowired
    private NoteService noteService;
    @GetMapping("/registration") // http://localhost:8080/hello/Notes
    public String getHelloPage(Model model) {
        model.addAttribute("userData", new User());
        return "registration";

    }

    @PostMapping("/registration")
    public String siteRegister(@ModelAttribute User user, Model model) {
        User validatedUser = noteService.validateUser(user);
        model.addAttribute("status", validatedUser ==null ? "error" : "success");
        model.addAttribute("user", validatedUser == null ? user : validatedUser);

        return "redirect:/registration";
    }

    @GetMapping("/noteRegistration")
    public String getNotes(Model model) {
        model.addAttribute("user", noteService.getUsers());
        model.addAttribute("note", noteService.getNotes());
        model.addAttribute("categories", noteService.getCategories());
        model.addAttribute("noteData", new Note());
        return "noteRegistration";
    }

    @GetMapping("/noteRegistration/{id}")
    public String getNotes(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("user", noteService.getUsers());
        model.addAttribute("categories", noteService.getCategories());
        model.addAttribute("note", noteService.getNoteCategories(id));
        model.addAttribute("noteData", new Note());
        return "noteRegistration";
    }

    @GetMapping("/noteRegistrationUser/{id}")
    public String getNotesU(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("user", noteService.getUsers());
        model.addAttribute("categories", noteService.getCategories());
        model.addAttribute("noteU", noteService.getNoteUsers(id));
        model.addAttribute("noteData", new Note());
        return "noteRegistrationUser";
    }

    @PostMapping("/noteRegistration")
    public String addNotes(@ModelAttribute Note note) {
        noteService.validateNote(note);
        return "redirect:/noteRegistration";
    }

    @PostMapping("/noteRegistrationUser")
    public String addNotesU(@ModelAttribute Note note) {
        noteService.validateNote(note);
        return "redirect:/noteRegistrationUser";
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("category", noteService.getCategories());
        model.addAttribute("categoryData", new Category());
        return "categories";
    }

    @PostMapping("/categories")
    public String addCategory(@ModelAttribute Category category) {
        noteService.storeCategory(category);
        return "redirect:/categories";
    }
}
