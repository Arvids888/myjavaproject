package model;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private Long id;
    private User user;
    private Category category;
    private String personalNote;
    private String title;


    private List<Note> notes = new ArrayList<>();


    public Note(Long id, User user, Category category, String personalNote, String title) {
        this.id = id;
        this.user = user;
        this.category = category;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPersonalNote() {
        return personalNote;
    }

    public void setPersonalNote(String personalNote) {
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
