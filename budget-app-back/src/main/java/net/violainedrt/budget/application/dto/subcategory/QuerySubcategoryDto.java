package net.violainedrt.budget.application.dto.subcategory;

import lombok.*;


@Builder(toBuilder = true)
public record QuerySubcategoryDto(Long id,
                             String name,
                             String colorCode,
                             Boolean isFlagged,
                             Long categoryId) {

}

