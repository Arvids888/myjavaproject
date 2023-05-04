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

    public List<Category> getCategory(long id) {
        return noteDao.getCategoryId(id);
    }

    public List<User> getUsers(long id) {
        return noteDao.getUserId(id);
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
            noteDao.storeUser(user);
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
