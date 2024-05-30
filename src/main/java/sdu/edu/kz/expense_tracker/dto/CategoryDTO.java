package sdu.edu.kz.expense_tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(
        description = "Category DTO - transfer the data between client and server"
)
public record CategoryDTO(

        Long categoryId,
        @NotBlank
        @Schema(description = "Category name", example = "For fun",requiredMode = Schema.RequiredMode.REQUIRED)
        String categoryName
) {
}
