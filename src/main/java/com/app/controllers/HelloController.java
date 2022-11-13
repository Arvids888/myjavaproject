package com.app.controllers;

import com.app.services.Note;
import com.app.services.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HelloController {


    @GetMapping("/notessite/{userName}") // http://localhost:8080/hello/Dmitrijs
    public String getHelloPage(@PathVariable(value = "userName") String userName, Model model) {
        User scott = new User("Scoot", "Peterson", 45, "scoot@peterson.com");
        User albert = new User("Albert", "Evans", 23, "albert@evans.com");


        scott.addNote(new Note("ScootsNoteOne", "ScootOne"));
        albert.addNote(new Note("AlbertsNoteOne", "AlbertOne"));


        List<Note> scootNotes = scott.getNotes();
        List<Note> albertNotes = albert.getNotes();

        /*for (int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i).getId());
        }*/


        for (Note sn : scootNotes) {
            if (sn.getId().startsWith("Scoot")) {
                System.out.println(sn.getId());
            } else {
                System.out.println("Wrong");
            }

            System.out.println();
        }

        for (Note sn : scootNotes) {
            for (Note an : albertNotes) {
                if (sn.getId().startsWith("Scoot") && an.getId().startsWith("Albert")) {
                    System.out.println(sn.getId() + " " + an.getId());
                }
            }
            model.addAttribute("name", userName + " " + sn.getId());
            return "notessite";


        }

        return userName;
    }

}