package com.enigmacamp.wmb.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
public class UnauthorizedException extends RuntimeException {
    private String code = "X05";
    private String status = "UNAUTHORIZED";

    public UnauthorizedException() {
        super("Unauthorized");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
