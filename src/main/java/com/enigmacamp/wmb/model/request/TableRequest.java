package com.enigmacamp.wmb.model.request;

import com.enigmacamp.wmb.enums.Availability;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TableRequest {
    @NotBlank(message = "Table number is required")
    private String tableNumber;

    private Availability tableStatus;
}
