package net.violainedrt.budget.application.dto.goal;

import jakarta.validation.constraints.Digits;
import lombok.*;
import net.violainedrt.budget.common.enums.FinancialType;
import net.violainedrt.budget.common.enums.Periodicity;


import java.math.BigDecimal;

@Builder(toBuilder = true)
public record UpdateGoalDto(
        @Digits(integer = 15, fraction = 2, message = "maxAmount takes up to 15 digits and up to 2 decimal places")
        BigDecimal maxAmount,
        Periodicity periodicity,
        FinancialType financialType,
        Long categoryId,
        Long subcategoryId) {
}