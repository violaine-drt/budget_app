package net.violainedrt.budget.application.dto.supplier;

import lombok.*;

@Builder(toBuilder = true)
public record UpdateSupplierDto(
                          String name) {

}