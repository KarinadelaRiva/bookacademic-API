package com.bookademic.bookademic.exceptions.domainExceptions.unsupportedType;

public class UnsupportedRequestTypeException extends UnsupportedTypeException {
    public UnsupportedRequestTypeException(String typeName) {
        super("Unsupported request type: " + typeName);
    }
}
