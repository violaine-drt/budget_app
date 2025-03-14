package net.violainedrt.budget.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record SupplierDto(Long id,
                          String name,
                          Long userId,
                          LocalDateTime createdAt,
                          LocalDateTime updatedAt) {

}