package com.app.controllers;

import com.app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllNotesController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/allnotes")
    public String getAllNotesPage(Model model) {
        model.addAttribute("allnotes", noteService.getNotes());
        return "allnotes";
    }
}
