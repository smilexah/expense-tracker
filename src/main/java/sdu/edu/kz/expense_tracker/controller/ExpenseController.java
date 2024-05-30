package sdu.edu.kz.expense_tracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sdu.edu.kz.expense_tracker.dto.ExpenseDTO;
import sdu.edu.kz.expense_tracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/")
    public ResponseEntity<Void> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long expenseId) {
        return new ResponseEntity<>(expenseService.getExpenseById(expenseId), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable Long expenseId) {
        expenseService.deleteExpenseById(expenseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long expenseId, @RequestBody ExpenseDTO expenseDTO) {
        expenseService.updateExpense(expenseId, expenseDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
