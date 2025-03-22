package net.violainedrt.budget.application.dto.supplier;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder(toBuilder = true)
public record UpdateSupplierDto(
        @NotNull(message = "name is mandatory on supplier entity")
        @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
        String name) {

}