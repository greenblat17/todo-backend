package com.greenblat.backend.todo.controller;

import com.greenblat.backend.todo.entity.Category;
import com.greenblat.backend.todo.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }
}
