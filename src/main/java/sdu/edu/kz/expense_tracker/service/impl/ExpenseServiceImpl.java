package sdu.edu.kz.expense_tracker.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sdu.edu.kz.expense_tracker.dto.ExpenseDTO;
import sdu.edu.kz.expense_tracker.entity.Category;
import sdu.edu.kz.expense_tracker.entity.Expense;
import sdu.edu.kz.expense_tracker.exception.ResourceNotFoundException;
import sdu.edu.kz.expense_tracker.mapper.ExpenseMapper;
import sdu.edu.kz.expense_tracker.repository.CategoryRepository;
import sdu.edu.kz.expense_tracker.repository.ExpenseRepository;
import sdu.edu.kz.expense_tracker.service.ExpenseService;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void createExpense(ExpenseDTO expenseDTO) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDTO);
        expenseRepository.save(expense);
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses
                .stream()
                .map(ExpenseMapper::mapToExpenseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Expense not found for expenseId: " + expenseId));

        expenseRepository.delete(expense);
    }

    @Override
    public void updateExpense(Long expenseId, ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(
                        () -> new RuntimeException("Expense not found for expenseId: " + expenseId));

        expense.setAmount(expenseDTO.amount());
        expense.setExpenseDate(expenseDTO.expenseDate());

        if(expenseDTO.categoryDTO() != null){

            // get the category entity by id
            Category category = categoryRepository.findById(expenseDTO.categoryDTO().categoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + expenseDTO.categoryDTO().categoryId()));

            expense.setCategory(category);
        }

        expenseRepository.save(expense);
    }

    @Override
    public ExpenseDTO getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Expense not found for expenseId: " + expenseId));

        return ExpenseMapper.mapToExpenseDTO(expense);
    }
}
