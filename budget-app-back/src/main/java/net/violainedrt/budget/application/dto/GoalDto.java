package net.violainedrt.budget.application.dto;

import lombok.*;
import net.violainedrt.budget.common.enums.FinancialType;
import net.violainedrt.budget.common.enums.Periodicity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record GoalDto(Long id,
                      BigDecimal maxAmount,
                      Periodicity periodicity,
                      FinancialType financialType,
                      Long categoryId,
                      Long userId,
                      Long subcategoryId,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt) {
}