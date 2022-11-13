package com.app.services;

import com.app.services.Note;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String eMail;
    private List<Note> notes = new ArrayList<>();


    public User(String firstName, String lastName, int age, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.eMail = eMail;

    }

    public User() {

    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

}

