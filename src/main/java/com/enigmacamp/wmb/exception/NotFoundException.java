package com.enigmacamp.wmb.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
public class NotFoundException extends RuntimeException {
    private final String code = "X01";
    private final String status = "NOT FOUND";

    public NotFoundException() {
        super("Data Not Found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
