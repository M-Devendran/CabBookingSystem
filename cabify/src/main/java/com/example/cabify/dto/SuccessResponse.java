package com.example.cabify.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class SuccessResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;

    public SuccessResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}