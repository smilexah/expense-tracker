package sdu.edu.kz.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.edu.kz.expense_tracker.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
