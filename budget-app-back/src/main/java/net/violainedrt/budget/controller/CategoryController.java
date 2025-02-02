package net.violainedrt.budget.controller;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.CategoryDto;
import net.violainedrt.budget.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    // Build Add Category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryDto.setCreatedAt(LocalDateTime.now());
        categoryDto.setUpdatedAt(LocalDateTime.now());
        CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    //Build Get Category REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    //Build Get All categories REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    //Build update Category REST API
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto updatedCategory) {
        CategoryDto categoryDto = categoryService.updateCategory(categoryId, updatedCategory);
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
