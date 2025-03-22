package net.violainedrt.budget.application.dto.subcategory;

import jakarta.validation.constraints.*;
import lombok.*;


@Builder(toBuilder = true)
public record UpdateSubcategoryDto(
        @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
        String name,
        @Pattern(regexp = "^#[0-9A-Fa-f]{6}$", message = "Color code mus be valid hexadecimal (ex: #FFFFFF)")
        String colorCode,
        Boolean isFlagged) {

}

