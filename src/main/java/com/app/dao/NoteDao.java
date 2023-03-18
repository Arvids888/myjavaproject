package com.app.dao;

import model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class NoteDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Note> getNotes() {
        RowMapper<Note> rowMapper = (rs, rowNumber) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT * FROM notes", rowMapper);
    }

    private Note mapNotes(ResultSet rs) throws SQLException {
        Note note = new Note();

        note.setId(rs.getLong("id"));
        note.setpersonalNote(rs.getString("personal_note"));
        note.setTitle(rs.getString("title"));

        return note;
    }

    public void storeNote(Note note) {
        jdbcTemplate.update("INSERT INTO notes (user_id, personal_note, title) VALUES ('123', ?, ?)",
                note.getpersonalNote(), note.getTitle());
    }
}
