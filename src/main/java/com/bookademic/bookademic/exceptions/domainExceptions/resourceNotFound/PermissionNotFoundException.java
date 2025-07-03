package com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound;

public class PermissionNotFoundException extends ResourceNotFoundException {
    public PermissionNotFoundException(String message) {
        super(message);
    }
}
