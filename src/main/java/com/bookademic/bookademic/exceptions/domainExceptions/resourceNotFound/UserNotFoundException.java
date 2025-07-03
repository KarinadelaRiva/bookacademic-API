package com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
