package sdu.edu.kz.expense_tracker.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(name = "Error Details DTO")
public class ErrorDetails {
    @Schema(description = "Error occurred date time")
    private LocalDateTime timeStamp;
    @Schema(description = "Error message")
    private String message;
    @Schema(description = "Error details")
    private String details;
    @Schema(description = "Error code")
    private String errorCode;
}
