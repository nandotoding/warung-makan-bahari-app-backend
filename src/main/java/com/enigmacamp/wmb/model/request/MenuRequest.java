package com.enigmacamp.wmb.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MenuRequest {
    @NotBlank(message = "Menu name is required")
    private String name;

    @NotNull(message = "Menu price is required")
    private Double price;
}
