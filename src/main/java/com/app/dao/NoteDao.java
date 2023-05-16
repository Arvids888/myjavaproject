package com.app.dao;

import model.Category;
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
        RowMapper<User> rowMapper = (rs, rowNumber) -> mapUsers(rs);
        return jdbcTemplate.query("SELECT * FROM users", rowMapper);
    }

    private User mapUsers(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));

        return user;
    }

    public void storeAllUser(User user) {
        jdbcTemplate.update("INSERT INTO users (first_name, last_name, email, phone, password) VALUES (?, ?, ?, ?, '777')",
                user.getFirstName(), user.getLastName(), user.geteMail(), user.getPhone());
    }

    public List<Note> getNotes() {
        RowMapper<Note> rowMapper = (rs, rowNumber) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT n.id AS n_id, n.personal_note AS n_personal_note, n.title AS n_title, " +
                "u.id AS u_id, u.first_name AS u_first_name, u.last_name AS u_last_name, c.id AS c_id, c.name AS c_name " +
                "FROM notes n " +
                "INNER JOIN users u ON n.user_id = u.id " +
                "INNER JOIN categories c ON n.category_id = c.id", rowMapper);
    }

    public List<Note> getCategoryNotesId(long id) {
        RowMapper<Note> rowMapper = (rs, rowNumber) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT n.id AS n_id, n.personal_note AS n_personal_note, n.title AS n_title, " +
                "u.id AS u_id, u.first_name AS u_first_name, u.last_name AS u_last_name, c.id AS c_id, c.name AS c_name " +
                "FROM notes n " +
                "INNER JOIN users u ON n.user_id = u.id " +
                "INNER JOIN categories c ON n.category_id = c.id " +
                "WHERE n.category_id = ?", rowMapper, id);
    }

    public List<Note> getUserNotesId(long id) {
        RowMapper<Note> rowMapper = (rs, rowNumber) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT n.id AS n_id, n.personal_note AS n_personal_note, n.title AS n_title, " +
                "u.id AS u_id, u.first_name AS u_first_name, u.last_name AS u_last_name, c.id AS c_id, c.name AS c_name " +
                "FROM notes n " +
                "INNER JOIN users u ON n.user_id = u.id " +
                "INNER JOIN categories c ON n.category_id = c.id " +
                "WHERE n.user_id = ?", rowMapper, id);
    }

    private Note mapNotes(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("u_id"));
        user.setFirstName(rs.getString("u_first_name"));
        user.setLastName(rs.getString("u_last_name"));

        Category category = new Category();
        category.setId(rs.getLong("c_id"));
        category.setName(rs.getString("c_name"));

        Note note = new Note();
        note.setUser(user);
        note.setCategory(category);
        note.setId(rs.getLong("n_id"));
        note.setPersonalNote(rs.getString("n_personal_note"));
        note.setTitle(rs.getString("n_title"));

        return note;
    }

    public void storeNote(Note note) {
        jdbcTemplate.update("INSERT INTO notes (user_id, category_id, personal_note, title) VALUES (?, ?, ?, ?)",
                note.getUser().getId(), note.getCategory().getId(), note.getPersonalNote(), note.getTitle());
    }

    public List<Category> getCategories() {
        RowMapper<Category> rowMapper = (rs, rowNumber) -> mapCategories(rs);
        return jdbcTemplate.query("SELECT * FROM categories", rowMapper);
    }

    private Category mapCategories(ResultSet rs) throws SQLException {
        Category category = new Category();

        category.setId(rs.getLong("id"));
        category.setName(rs.getString("name"));

        return category;
    }

    public void storeCategory(Category category) {
        jdbcTemplate.update("INSERT INTO categories (name) VALUES (?)", category.getName());
    }
}
