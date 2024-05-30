package sdu.edu.kz.expense_tracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sdu.edu.kz.expense_tracker.dto.CategoryDTO;
import sdu.edu.kz.expense_tracker.entity.Category;
import sdu.edu.kz.expense_tracker.exception.ResourceNotFoundException;
import sdu.edu.kz.expense_tracker.mapper.CategoryMapper;
import sdu.edu.kz.expense_tracker.repository.CategoryRepository;
import sdu.edu.kz.expense_tracker.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.mapToCategory(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(CategoryMapper::mapToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for categoryId: " + categoryId));

        categoryRepository.delete(category);
    }

    @Override
    public void updateCategoryById(Long categoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for categoryId: " + categoryId));

        category.setCategoryName(categoryDTO.categoryName());
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for categoryId: " + categoryId));
        return CategoryMapper.mapToCategoryDTO(category);
    }
}
