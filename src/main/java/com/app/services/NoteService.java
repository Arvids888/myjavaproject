package com.app.services;

import com.app.dao.NoteDao;
import model.Note;
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

    public Note validateNote(Note note) {
        if (!note.getpersonalNote().isEmpty() &&
                !note.getTitle().isEmpty()) {

            noteDao.storeNote(note);
            return note;
        }

        return null;
    }
}
