package com.app.dao;

import model.Note;
import model.User;
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

    public List<User> getUsers() {
        RowMapper<User> rowMapper = (rs, rowNumber) -> mapUser(rs);
        return jdbcTemplate.query("SELECT * FROM users", rowMapper);
    }

    private User mapUser(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.seteMail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));

        return user;
    }

    public void storeUser(User user) {
        jdbcTemplate.update("INSERT INTO users (first_name, last_name, email, phone, password) VALUES (?, ?, ?, ?, '777')",
                user.getFirstName(), user.getLastName(), user.geteMail(), user.getPhone());
    }

    public List<Note> getNotes() {
        RowMapper<Note> rowMapper = (rs, rowNumber) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT n.id AS n_id, n.personal_note AS n_personal_note, n.title AS n_title, " +
                "u.id AS u_id, u.first_name AS u_first_name, u.last_name AS u_last_name " +
                "FROM notes n " +
                "INNER JOIN users u ON n.user_id = u.id" , rowMapper);
    }

    private Note mapNotes(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("u_id"));
        user.setFirstName(rs.getString("u_first_name"));
        user.setFirstName(rs.getString("u_last_name"));

        Note note = new Note();
        note.setUser(user);
        note.setId(rs.getLong("id"));
        note.setpersonalNote(rs.getString("personal_note"));
        note.setTitle(rs.getString("title"));

        return note;
    }

    public void storeNote(Note note) {
        jdbcTemplate.update("INSERT INTO notes (user_id, personal_note, title) VALUES (?, ?, ?)",
                note.getpersonalNote(), note.getTitle());
    }
}
