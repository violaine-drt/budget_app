package net.violainedrt.budget.application.dto;

import lombok.*;

import java.time.LocalDateTime;


@Builder(toBuilder = true)
public record CategoryDto(Long id,
                          String name,
                          String colorCode,
                          Boolean isFlagged,
                          Boolean isDefault,
                          Long userId,
                          LocalDateTime createdAt,
                          LocalDateTime updatedAt) {
}
