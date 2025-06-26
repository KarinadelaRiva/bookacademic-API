package com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound;

public class RoleNotFoundException extends ResourceNotFoundException {
    public RoleNotFoundException(String message) {
        super(message);
    }
}
