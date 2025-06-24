package com.bookademic.bookademic.exceptions.domainExceptions;

public abstract class UnsupportedTypeException extends RuntimeException {
    public UnsupportedTypeException(String message) {
        super(message);
    }
}
