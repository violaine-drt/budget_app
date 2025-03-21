package net.violainedrt.budget.application.controller;

import lombok.AllArgsConstructor;

import net.violainedrt.budget.application.dto.category.*;
import net.violainedrt.budget.domain.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories") //indique que toutes les routes débuterons par ce segment
public class CategoryController {
    private CategoryService categoryService;

    // Build Add Category REST API
    //@todo changer construction objet category
    @PostMapping
    public ResponseEntity<QueryCategoryDto> createCategory(@RequestBody CreateCategoryDto category) {
        QueryCategoryDto savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    //Build Get Category REST API
    @GetMapping("{id}")
    public ResponseEntity<QueryCategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {
        QueryCategoryDto category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    //Build Get All categories REST API
    @GetMapping
    public ResponseEntity<List<QueryCategoryDto>> getAllCategories() {
        List<QueryCategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    //Build update Category REST API
    @PutMapping("{id}")
    public ResponseEntity<QueryCategoryDto> updateCategory(@PathVariable("id") Long categoryId, @RequestBody UpdateCategoryDto category) {
        QueryCategoryDto updatedCategory = categoryService.updateCategory(categoryId, category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
