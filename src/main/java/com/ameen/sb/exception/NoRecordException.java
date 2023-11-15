package com.ameen.sb.exception;

public class NoRecordException extends RuntimeException {
    String message;
    public NoRecordException(String recordNotFound) {
        this.message = recordNotFound;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
