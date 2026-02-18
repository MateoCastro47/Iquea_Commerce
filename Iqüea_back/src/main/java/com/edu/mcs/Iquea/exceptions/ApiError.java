package com.edu.mcs.Iquea.exceptions;

import java.time.LocalDateTime;

public class ApiError {
    private int status;
    private String mensaje;
    private LocalDateTime timestamp;

    public ApiError(int status, String mensaje) {
        this.status = status;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public int getStatus() { return status; }
    public String getMensaje() { return mensaje; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
