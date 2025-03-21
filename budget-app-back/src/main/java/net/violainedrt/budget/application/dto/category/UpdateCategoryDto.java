package net.violainedrt.budget.application.dto.category;

import lombok.*;


@Builder(toBuilder = true)
public record UpdateCategoryDto(
                          String name,
                          String colorCode,
                          Boolean isFlagged) {
}
