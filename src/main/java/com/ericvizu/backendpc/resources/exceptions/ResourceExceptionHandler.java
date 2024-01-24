package com.ericvizu.backendpc.resources.exceptions;

import com.ericvizu.backendpc.services.exceptions.DuplicateItemException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(DuplicateItemException.class)
    public ResponseEntity<StandardError> objectAlreadyExists(DuplicateItemException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(status.value(), "Already exists",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
