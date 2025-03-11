package net.violainedrt.budget.application.dto;

import lombok.*;

@Builder(toBuilder = true)
public record SupplierDto(Long id,
                          String name,
                          Long userId) {

}