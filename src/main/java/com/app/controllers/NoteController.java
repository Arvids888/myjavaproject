//package com.app.controllers;
//
//import com.app.services.NoteService;
//import com.app.services.UserService;
//import model.Note;
//import model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class NoteController {
//    @Autowired
//    private NoteService noteService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private HelloController helloController;
//    @GetMapping("/noteRegistration") // http://localhost:8080/hello/Notes
//    public String getNotePage(Model model) {
//        model.addAttribute("noteData", new Note());
//        return "noteRegistration";
//
//    }
//
//    @PostMapping("/noteRegistration")
//    public String siteRegister(@ModelAttribute Note note, User user, Model model) {
//        Note validatedNote = noteService.validateNote(note);
//        model.addAttribute("status", validatedNote ==null ? "error" : "success");
//        model.addAttribute("note", validatedNote == null ? note : validatedNote);
//        model.addAttribute("firstName", userService.validateUser(user).getFirstName());
//        return "redirect:/successRegistration";
//    }
//}
