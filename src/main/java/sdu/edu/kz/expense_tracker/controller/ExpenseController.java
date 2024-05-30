package sdu.edu.kz.expense_tracker.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Expense Controller", description = "Controller for the Expense Resource")
@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/")
    @Operation(summary = "Create a new Expense")
    @ApiResponse(responseCode = "201", description = "Created a new Expense successfully.")
    @ApiResponse(responseCode = "401", description = "Token missing")
    @ApiResponse(responseCode = "403", description = "Token error")
//    @SecurityRequirement(name = "ex-tracker-api")
    public ResponseEntity<Void> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get Expense by ID")
    @ApiResponse(responseCode = "200", description = "Expense ID with data returned successfully.")
    @ApiResponse(responseCode = "401", description = "Token missing")
    @ApiResponse(responseCode = "403", description = "Token error")
    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long expenseId) {
        return new ResponseEntity<>(expenseService.getExpenseById(expenseId), HttpStatus.OK);
    }

    @Operation(summary = "List all expenses")
    @ApiResponse(responseCode = "200", description = "List all expenses returned successfully.")
    @ApiResponse(responseCode = "401", description = "Token missing")
    @ApiResponse(responseCode = "403", description = "Token error")
    @GetMapping("/")
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @Operation(summary = "Delete a expense")
    @ApiResponse(responseCode = "204", description = "Expense was deleted successfully.")
    @ApiResponse(responseCode = "401", description = "Token missing")
    @ApiResponse(responseCode = "403", description = "Token error")
    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable Long expenseId) {
        expenseService.deleteExpenseById(expenseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update existing expense")
    @ApiResponse(responseCode = "204", description = "Expense updated successfully.")
    @ApiResponse(responseCode = "401", description = "Token missing")
    @ApiResponse(responseCode = "403", description = "Token error")
    @PutMapping("/{expenseId}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long expenseId, @RequestBody ExpenseDTO expenseDTO) {
        expenseService.updateExpense(expenseId, expenseDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
