package sdu.edu.kz.expense_tracker.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
    private String errorCode;
}
