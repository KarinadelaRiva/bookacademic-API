package com.bookademic.bookademic.exceptions.domainExceptions;

public class UnsupportedSpaceTypeException extends UnsupportedTypeException {
    public UnsupportedSpaceTypeException(String typeName) {
        super("Unsupported space type: " + typeName);
    }
}
