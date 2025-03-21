package net.violainedrt.budget.application.dto.category;

import lombok.*;


@Builder(toBuilder = true)
public record QueryCategoryDto(Long id,
                          String name,
                          String colorCode,
                          Boolean isFlagged,
                          Boolean isDefault,
                          Long userId) {
}
