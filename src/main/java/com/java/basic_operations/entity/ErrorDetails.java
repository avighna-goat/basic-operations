package com.java.basic_operations.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
//todo use @Builder
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
