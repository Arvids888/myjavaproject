package com.app.services;

import com.app.dao.NoteDao;
import model.Category;
import model.Note;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public List<Note> getNotes() {
        return noteDao.getNotes();
    }

    public List<Note> getNoteCategories(long id) {
        return noteDao.getCategoryNotesId(id);
    }

    public List<Note> getNoteUsers(long id) {
        return noteDao.getUserNotesId(id);
    }

    public Note validateNote(Note note) {
        if (!note.getPersonalNote().isEmpty() &&
                !note.getTitle().isEmpty()) {

            noteDao.storeNote(note);
            return note;
        }

        return null;
    }

    public List<User> getUsers() {
        return noteDao.getUsers();
    }

    public User validateUser(User user) {
        if (!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() &&
                !user.geteMail().isEmpty() && !user.getPhone().isEmpty()) {

            String phone = user.getPhone().trim().replaceAll("\\(", "")
                    .replaceAll("\\)", "");
            user.setPhone(phone);
            noteDao.storeAllUser(user);
            return user;
        }

        return null;
    }

    public List<Category> getCategories() {
        return noteDao.getCategories();
    }

    public void storeCategory(Category category) {
        noteDao.storeCategory(category);
    }
}
