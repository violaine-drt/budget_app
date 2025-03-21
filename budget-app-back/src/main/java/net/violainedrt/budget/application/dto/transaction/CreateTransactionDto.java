package net.violainedrt.budget.application.dto.transaction;

import lombok.*;
import net.violainedrt.budget.common.enums.FinancialType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record CreateTransactionDto (
                                   String description,
                                   BigDecimal amount,
                                   LocalDateTime dateTime,
                                   FinancialType financialType,
                                   Long categoryId,
                                   Long subcategoryId,
                                   Long userId,
                                   Long supplierId) {

}