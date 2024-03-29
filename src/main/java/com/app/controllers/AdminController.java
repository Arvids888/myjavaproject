package com.app.controllers;

import com.app.services.AdminService;
import com.app.services.NoteService;
import model.Category;
import model.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/_admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", adminService.getCategories());
        model.addAttribute("category", new Category());
        return "admin/categories";
    }

    @PostMapping("/_admin/categories")
    public String addCategory(@ModelAttribute Category category) {
        adminService.storeCategory(category);
        return "redirect:/_admin/categories";
    }

    @GetMapping("/_admin/subcategories")
    public String getSubcategories(Model model) {
        model.addAttribute("categories", adminService.getCategories());
        model.addAttribute("subcategories", adminService.getSubcategories());
        model.addAttribute("newSubcategory", new Subcategory());

        return "admin/subcategories";
    }

    @PostMapping("/_admin/subcategories")
    public String addSubcategories(@ModelAttribute Subcategory subcategory) {
        adminService.storeSubcategory(subcategory);
        return "redirect:/_admin/subcategories";
    }
}
