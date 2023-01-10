package com.enigmacamp.wmb.controller;

import com.enigmacamp.wmb.exception.InvalidLoginException;
import com.enigmacamp.wmb.exception.InvalidRequestException;
import com.enigmacamp.wmb.exception.NotFoundException;
import com.enigmacamp.wmb.exception.UnauthorizedException;
import com.enigmacamp.wmb.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(InvalidRequestException.class)
    ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("X03", "BAD REQUEST", e.getMessage()));
    }

    @ExceptionHandler(InvalidLoginException.class)
    ResponseEntity<ErrorResponse> handleInvalidLoginException(InvalidLoginException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    ResponseEntity<ErrorResponse> handleUnauthorizationException(UnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(e.getCode(), e.getStatus(), e.getMessage()));
    }
}
