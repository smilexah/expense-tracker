package sdu.edu.kz.expense_tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO - transfer the data between client and server"
)
public record ExpenseDTO(
        Long expenseId,
        @NotBlank
        @Schema(description = "Expense amount")
        BigDecimal amount,
        @Schema(description = "Expense created date")
        LocalDate expenseDate,
        @Schema(description = "Associated Expense category")
        CategoryDTO categoryDTO
) {
}

