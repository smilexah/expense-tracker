package sdu.edu.kz.expense_tracker.service;

import sdu.edu.kz.expense_tracker.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories();
    void deleteCategoryById(Long categoryId);
    void updateCategoryById(Long categoryId, CategoryDTO categoryDTO);
    CategoryDTO getCategoryById(Long categoryId);
}
