package com.ericvizu.backendpc.resources.exceptions;

import com.ericvizu.backendpc.services.exceptions.DatabaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> objectAlreadyExists(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(status.value(), "Already exists",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
