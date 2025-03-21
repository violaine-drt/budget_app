package net.violainedrt.budget.application.dto.subcategory;

import lombok.*;


@Builder(toBuilder = true)
public record UpdateSubcategoryDto(
                             String name,
                             String colorCode,
                             Boolean isFlagged) {

}

