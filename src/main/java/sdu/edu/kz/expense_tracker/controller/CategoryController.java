package sdu.edu.kz.expense_tracker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sdu.edu.kz.expense_tracker.dto.CategoryDTO;
import sdu.edu.kz.expense_tracker.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Category Controller", description = "Controller for Category Resource")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    @Operation(summary = "Create a new Category")
    @ApiResponse(responseCode = "201", description = "Created a new Category successfully.")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    @Operation(summary = "Get category by ID")
    @ApiResponse(responseCode = "200", description = "Category ID with data returned successfully.")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long categoryId) {
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
    }

    @GetMapping("/")
    @Operation(summary = "Get all categories")
    @ApiResponse(responseCode = "200", description = "List all categories returned successfully.")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Delete a category")
    @ApiResponse(responseCode = "204", description = "Category was deleted successfully.")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{categoryId}")
    @Operation(summary = "Update existing category")
    @ApiResponse(responseCode = "204", description = "Category updated successfully.")
    public ResponseEntity<Void> updateCategoryById(@PathVariable Long categoryId, @RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategoryById(categoryId, categoryDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
