package com.app.services;

import com.app.dao.CatalogDao;
import model.Category;
import model.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService {

    @Autowired
    private CatalogDao catalogDao;

    public List<Category> getCategories() {
        return catalogDao.getCategories();
    }

    public void storeCategory(Category category) {
        catalogDao.storeCategory(category);
    }

    public List<Subcategory> getSubcategories() {
        return catalogDao.getSubcategories();
    }

    public void storeSubcategory(Subcategory subcategory) {
        catalogDao.storeSubcategory(subcategory);
    }
}
