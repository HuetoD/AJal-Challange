package com.ajal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

    private static final String VALIDATION_ERROR = "Hay un error de validación, verifique sus entradas";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationError(MethodArgumentNotValidException methodArgumentNotValidException) {
        final FieldError fieldError = methodArgumentNotValidException.getBindingResult()
                                                                    .getFieldErrors()
                                                                    .get(0);
        return createResponse(fieldError == null ? VALIDATION_ERROR : fieldError.getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenericGradeException.class)
    public ResponseEntity<String> gradeError(GenericGradeException genericGradeException) {
        return createResponse(genericGradeException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> createResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }


}
