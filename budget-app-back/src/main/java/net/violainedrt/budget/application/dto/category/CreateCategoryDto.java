package net.violainedrt.budget.application.dto.category;

import jakarta.validation.constraints.*;
import lombok.*;



@Builder(toBuilder = true)
public record CreateCategoryDto(
        @NotBlank(message = "Name is mandatory on category ")  // Empêche null et chaînes vides
        @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
        String name,
        @Pattern(regexp = "^#[0-9A-Fa-f]{6}$", message = "Color code mus be valid hexadecimal (ex: #FFFFFF)")
        @NotBlank(message = "Color code is mandatory on category")  // Empêche null et chaînes vides
        String colorCode,
        @NotNull(message = "'isFlagged' field is mandatory on category")
        Boolean isFlagged,
        @NotNull(message = "'isDefault' field is mandatory on category")
        Boolean isDefault,
        @NotNull(message = "User id is mandatory on category")
        Long userId
) {
}
