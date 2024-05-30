package sdu.edu.kz.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.edu.kz.expense_tracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
