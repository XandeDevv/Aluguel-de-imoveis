package com.example.Aluguel.de.imoveis.controllers.exceptions;

import java.time.Instant;

public class StandardError {

    private Instant TimeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(){

    }

    public StandardError(Instant timeStamp, Integer status, String error, String message, String path) {
        TimeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public void setTimeStamp(Instant timeStamp) {
        TimeStamp = timeStamp;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Instant getTimeStamp() {
        return TimeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
