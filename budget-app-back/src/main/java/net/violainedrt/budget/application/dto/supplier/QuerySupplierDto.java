package net.violainedrt.budget.application.dto.supplier;

import lombok.*;

@Builder(toBuilder = true)
public record QuerySupplierDto(Long id,
                          String name,
                          Long userId) {

}