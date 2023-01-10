package com.enigmacamp.wmb.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
public class InvalidLoginException extends RuntimeException {
    private String code = "X04";
    private String status = "FAILED";

    public InvalidLoginException() {
        super("Incorrect Username or Password");
    }
}
