package com.enigmacamp.wmb.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
public class InvalidRequestException extends RuntimeException {
    private final String code = "X02";
    private final String status = "BAD REQUEST";

    public InvalidRequestException() {
        super("Request is invalid");
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
