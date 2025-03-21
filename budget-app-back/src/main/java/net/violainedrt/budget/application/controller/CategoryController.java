package net.violainedrt.budget.application.controller;

import lombok.AllArgsConstructor;

import net.violainedrt.budget.application.dto.CategoryDto;
import net.violainedrt.budget.domain.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    // Build Add Category REST API
    //@todo changer construction objet category
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody net.violainedrt.budget.application.dto.CategoryDto categoryDto) {
        categoryDto.setCreatedAt(LocalDateTime.now());
        categoryDto.setUpdatedAt(LocalDateTime.now());
        net.violainedrt.budget.application.dto.CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    //Build Get Category REST API
    @GetMapping("{id}")
    public ResponseEntity<net.violainedrt.budget.application.dto.CategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {
        net.violainedrt.budget.application.dto.CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    //Build Get All categories REST API
    @GetMapping
    public ResponseEntity<List<net.violainedrt.budget.application.dto.CategoryDto>> getAllCategories() {
        List<net.violainedrt.budget.application.dto.CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    //Build update Category REST API
    @PutMapping("{id}")
    public ResponseEntity<net.violainedrt.budget.application.dto.CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                                                             @RequestBody net.violainedrt.budget.application.dto.CategoryDto updatedCategory) {
        net.violainedrt.budget.application.dto.CategoryDto categoryDto = categoryService.updateCategory(categoryId, updatedCategory);
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
