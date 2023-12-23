package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private Note note;
    private String firstName;
    private String lastName;
    private String phone;
    private String eMail;
    private String password;
    private String userName;
    private List<Note> notes = new ArrayList<>();
    private List<User> users = new ArrayList<>();


    public User(String firstName, String lastName, String phone, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.eMail = eMail;

    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
//    public Note getNote(String noteId) {
//        for (Note note : notes) {
//            if (note.getUser_id().equals(noteId)) {
//                return note;
//            }
//        }
//        return null;
//
//    }
//
//    public void displayNotes() {
//        for (Note note : notes) {
//            System.out.println(note.getUser_id());
//        }
//    }

}

