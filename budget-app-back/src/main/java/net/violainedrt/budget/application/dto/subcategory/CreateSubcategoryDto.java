package net.violainedrt.budget.application.dto.subcategory;

import jakarta.validation.constraints.*;
import lombok.*;


@Builder(toBuilder = true)
public record CreateSubcategoryDto(
        @NotNull(message = "name is mandatory on subcategory entity")
        @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
        String name,
        @NotNull(message = "colorCode is mandatory on subcategory entity")
        @Pattern(regexp = "^#[0-9A-Fa-f]{6}$", message = "Color code mus be valid hexadecimal (ex: #FFFFFF)")
        String colorCode,
        @NotNull(message = "isFlagged is mandatory on subcategory entity")
        Boolean isFlagged,
        @NotNull(message = "category is mandatory on subcategory entity")
        Long categoryId) {

}

