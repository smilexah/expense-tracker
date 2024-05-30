package sdu.edu.kz.expense_tracker.mapper;

import sdu.edu.kz.expense_tracker.dto.CategoryDTO;
import sdu.edu.kz.expense_tracker.dto.ExpenseDTO;
import sdu.edu.kz.expense_tracker.entity.Category;
import sdu.edu.kz.expense_tracker.entity.Expense;

public class ExpenseMapper {
    public static ExpenseDTO mapToExpenseDTO(Expense expense) {
        return new ExpenseDTO(
                expense.getExpenseId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDTO(
                        expense.getCategory().getId(),
                        expense.getCategory().getCategoryName()));
    }

    public static Expense mapToExpense(ExpenseDTO expenseDTO) {
        Category category = new Category();
        category.setId(expenseDTO.categoryDTO().categoryId());

        return new Expense(
                expenseDTO.expenseId(),
                expenseDTO.amount(),
                expenseDTO.expenseDate(),
                category);
    }

}
