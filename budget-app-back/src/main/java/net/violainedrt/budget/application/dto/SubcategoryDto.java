package net.violainedrt.budget.application.dto;

import lombok.*;

import java.time.LocalDateTime;


@Builder(toBuilder = true)
public record SubcategoryDto(Long id,
                             String name,
                             String colorCode,
                             Boolean isFlagged,
                             Long categoryId,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt) {

}

