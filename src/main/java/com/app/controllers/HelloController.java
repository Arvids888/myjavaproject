package com.app.controllers;

import com.app.services.NoteService;
import com.app.services.UserService;
import model.Note;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;
    @GetMapping("/registration") // http://localhost:8080/hello/Notes
    public String getHelloPage(Model model) {
        model.addAttribute("userData", new User());
        return "registration";

    }

    @PostMapping("/registration")
    public String siteRegister(@ModelAttribute User user, Model model) {
        User validatedUser = userService.validateUser(user);
        model.addAttribute("status", validatedUser ==null ? "error" : "success");
        model.addAttribute("user", validatedUser == null ? user : validatedUser);

        return "redirect:/registration";
    }

    @GetMapping("/noteRegistration")
    public String getNotes(Model model) {
        model.addAttribute("user", noteService.getUsers());
        model.addAttribute("note", noteService.getNotes());
        model.addAttribute("newNote", new Note());
        return "note";
    }

    @PostMapping("redirect:/noteRegistration")

    public String addNotes(@ModelAttribute Note note) {
        noteService.st
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
