package net.violainedrt.budget.application.dto.goal;

import lombok.*;
import net.violainedrt.budget.common.enums.FinancialType;
import net.violainedrt.budget.common.enums.Periodicity;


import java.math.BigDecimal;

@Builder(toBuilder = true)
public record UpdateGoalDto(
                      BigDecimal maxAmount,
                      Periodicity periodicity,
                      FinancialType financialType,
                      Long categoryId,
                      Long subcategoryId) {
}