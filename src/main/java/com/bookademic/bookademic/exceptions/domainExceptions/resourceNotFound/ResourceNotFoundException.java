package com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound;

public abstract class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
