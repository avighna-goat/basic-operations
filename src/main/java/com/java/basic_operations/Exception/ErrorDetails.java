package com.java.basic_operations.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime TimeStamp;
    private String Message;
    private String Details;

    public LocalDateTime getTimeStamp() {
        return TimeStamp;
    }

    public String getMessage() {
        return Message;
    }

    public String getDetails() {
        return Details;
    }

    public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
        TimeStamp = timeStamp;
        Message = message;
        Details = details;
    }
}
