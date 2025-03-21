package net.violainedrt.budget.application.dto.category;

import lombok.*;



@Builder(toBuilder = true)
public record CreateCategoryDto(
                          String name,
                          String colorCode,
                          Boolean isFlagged,
                          Boolean isDefault,
                          Long userId) {
}
