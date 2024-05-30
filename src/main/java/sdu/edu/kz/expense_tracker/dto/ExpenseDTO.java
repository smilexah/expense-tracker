package sdu.edu.kz.expense_tracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDTO(
        Long expenseId,
        BigDecimal amount,
        LocalDate expenseDate,
        CategoryDTO categoryDTO
) {
}
