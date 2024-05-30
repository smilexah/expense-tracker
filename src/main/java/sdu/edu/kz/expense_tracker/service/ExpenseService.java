package sdu.edu.kz.expense_tracker.service;

import java.util.List;

import sdu.edu.kz.expense_tracker.dto.ExpenseDTO;

public interface ExpenseService {
    void createExpense(ExpenseDTO expenseDTO);
    List<ExpenseDTO> getAllExpenses();
    void deleteExpenseById(Long expenseId);
    void updateExpense(Long expenseId, ExpenseDTO expenseDTO);
    ExpenseDTO getExpenseById(Long expenseId);
}
