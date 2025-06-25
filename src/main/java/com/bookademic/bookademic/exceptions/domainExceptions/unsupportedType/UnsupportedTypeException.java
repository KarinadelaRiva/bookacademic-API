package com.bookademic.bookademic.exceptions.domainExceptions.unsupportedType;

public abstract class UnsupportedTypeException extends RuntimeException {
    public UnsupportedTypeException(String message) {
        super(message);
    }
}
