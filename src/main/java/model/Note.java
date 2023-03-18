package model;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private Long id;
    private String personalNote;
    private String title;


    private List<Note> notes = new ArrayList<>();



    public Note(String personalNote, String title) {
        this.personalNote = personalNote;
        this.title = title;

    }

    public Note() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpersonalNote() {
        return personalNote;
    }

    public void setpersonalNote(String personalNote) {
        this.personalNote = personalNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }


}
