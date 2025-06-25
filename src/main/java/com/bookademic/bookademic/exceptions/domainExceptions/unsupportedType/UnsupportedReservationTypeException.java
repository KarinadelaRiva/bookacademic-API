package com.bookademic.bookademic.exceptions.domainExceptions.unsupportedType;

public class UnsupportedReservationTypeException extends UnsupportedTypeException {
    public UnsupportedReservationTypeException(String typeName) {
        super("Unsupported reservation type: " + typeName);
    }
}
