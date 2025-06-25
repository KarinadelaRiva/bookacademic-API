package com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound;

public class SubjectNotFoundException extends ResourceNotFoundException{
    public SubjectNotFoundException(String message) {
        super(message);
    }
}
