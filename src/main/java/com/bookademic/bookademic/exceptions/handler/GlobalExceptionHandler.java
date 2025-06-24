package com.bookademic.bookademic.exceptions.handler;

import com.bookademic.bookademic.exceptions.domainExceptions.UnsupportedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnsupportedTypeException.class)
    public ResponseEntity<ErrorResponse> handleUnsupportedType(UnsupportedTypeException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
