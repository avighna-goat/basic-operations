package com.java.basicoperations.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
