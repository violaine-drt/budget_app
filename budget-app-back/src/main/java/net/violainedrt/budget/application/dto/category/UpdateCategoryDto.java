package net.violainedrt.budget.application.dto.category;

import jakarta.validation.constraints.Size;
import lombok.*;


@Builder(toBuilder = true)
public record UpdateCategoryDto(
        @Size(min = 1, max = 150, message = "Le nom doit contenir entre 1 et 150 caractères")
        String name,
                          String colorCode,
                          Boolean isFlagged) {
}
