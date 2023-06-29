package com.app.controllers;

import com.app.services.NoteService;
import model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestNotesController {
    @Autowired
    private NoteService noteService;

    @CrossOrigin
    @GetMapping("/getNotes")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }
}
