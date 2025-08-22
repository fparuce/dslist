package com.fparucelabs.dslist.exceptions;

public class DomainException extends RuntimeException{
    private String message;
    private int status;

    public DomainException(String message, int status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
