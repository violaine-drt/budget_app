package net.violainedrt.budget.application.dto;

import lombok.*;
import net.violainedrt.budget.common.enums.FinancialType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record TransactionDto(Long id,
                             String description,
                             String counterparty,
                             BigDecimal amount,
                             LocalDateTime dateTime,
                             FinancialType financialType,
                             Long categoryId,
                             Long subcategoryId,
                             Long userId,
                             Long supplierId,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt) {

}
