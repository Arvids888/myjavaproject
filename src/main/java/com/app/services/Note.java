package com.app.services;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private String personalNote;
    private String id;

    private List<Note> notes = new ArrayList<>();



    public Note(String personalNote, String id) {
        this.personalNote = personalNote;
        this.id = id;
    }

    public Note() {

    }

    public String getpersonalNote() {
        return personalNote;
    }

    public void setpersonalNote(String personalNote) {
        this.personalNote = personalNote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

//    public void cycle() {
//        for ()
//    }
}
