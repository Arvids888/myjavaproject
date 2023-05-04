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
        model.addAttribute("category", noteService.getCategories());
        model.addAttribute("noteData", new Note());
        return "noteRegistration";
    }

    @GetMapping("/noteRegistration/{id}")
    public String getNotes(@PathVariable(value = "id") long id, Model model) {
//        model.addAttribute("user", noteService.getNotes(id));
        model.addAttribute("note", noteService.getNotes(id, id));
        model.addAttribute("category", noteService.getCategories());
        model.addAttribute("noteData", new Note());
        return "noteRegistration";
    }

//    @GetMapping("/noteRegistration/{id}")
//    public String getUsers(@PathVariable(value = "id") long id, Model model) {
//        model.addAttribute("user", noteService.getUsers(id));
//        model.addAttribute("note", noteService.getNotes());
//        model.addAttribute("category", noteService.getCategories());
//        model.addAttribute("noteData", new Note());
//        return "noteRegistration";
//    }

    @PostMapping("/noteRegistration")
    public String addNotes(@ModelAttribute Note note) {
        noteService.validateNote(note);
        return "redirect:/noteRegistration";
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

//    @GetMapping("/noteRegistration") // http://localhost:8080/hello/Notes
//    public String getNotePage(Model model) {
//        model.addAttribute("noteData", new Note());
//        return "noteRegistration";
//
//    }
//
//    @PostMapping("/noteRegistration")
//    public String siteNoteRegister(@RequestParam("user") @ModelAttribute Note note, String user, Model model) {
//        Note validatedNote = noteService.validateNote(note);
//        String validatedUser = getHelloPage(model);
//        model.addAttribute("status", validatedNote ==null ? "error" : "success");
//        model.addAttribute("note", validatedNote == null ? note : validatedNote);
//        model.addAttribute("user", validatedUser == null ? user : validatedUser);
//        return "successRegistration";
//    }
}
