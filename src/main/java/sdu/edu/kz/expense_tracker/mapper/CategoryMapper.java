package sdu.edu.kz.expense_tracker.mapper;

import sdu.edu.kz.expense_tracker.dto.CategoryDTO;
import sdu.edu.kz.expense_tracker.entity.Category;

public class CategoryMapper {
    public static Category mapToCategory(CategoryDTO categoryDTO) {
        return new Category(
                categoryDTO.categoryId(),
                categoryDTO.categoryName()
        );
    }

    public static CategoryDTO mapToCategoryDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getCategoryName()
        );
    }
}
