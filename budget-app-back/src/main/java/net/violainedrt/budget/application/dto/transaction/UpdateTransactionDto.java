package net.violainedrt.budget.application.dto.transaction;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record UpdateTransactionDto (
                                   String description,
                                   BigDecimal amount,
                                   LocalDateTime dateTime,
                                   Long categoryId,
                                   Long subcategoryId,
                                   Long supplierId) {

}