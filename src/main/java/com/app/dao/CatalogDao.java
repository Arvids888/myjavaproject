package com.app.dao;

import model.Category;
import model.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CatalogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> getCategories() {
        RowMapper<Category> rowMapper = (rs, rowNumber) -> mapCategory(rs);
        return jdbcTemplate.query("SELECT * FROM categories", rowMapper);
    }

    private Category mapCategory(ResultSet rs) throws SQLException {
        Category category = new Category();

        category.setId(rs.getLong("id"));
        category.setName(rs.getString("name"));

        return category;
    }

    public void storeCategory(Category category) {
        jdbcTemplate.update("INSERT INTO categories (name) VALUES (?)", category.getName());
    }

    public List<Subcategory> getSubcategories() {
        RowMapper<Subcategory> rowMapper = (rs, rowNumber) -> mapSubcategory(rs);
        return jdbcTemplate.query("SELECT * FROM subcategories", rowMapper);
    }

    private Subcategory mapSubcategory(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setId(rs.getLong("category_id"));

        Subcategory subcategory = new Subcategory();
        subcategory.setCategory(category);
        subcategory.setId(rs.getLong("id"));
        subcategory.setName(rs.getString("name"));

        return subcategory;
    }

    public void storeSubcategory(Subcategory subcategory) {
        jdbcTemplate.update("INSERT INTO subcategories (name, category_id) VALUES (?, ?)",
                subcategory.getName(), subcategory.getCategory().getId());
    }
}
