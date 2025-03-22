package net.violainedrt.budget.application.dto.transaction;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import net.violainedrt.budget.common.enums.FinancialType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record CreateTransactionDto (
        @Size(max = 255, message = "Description must be <= 255 characters")
        String description,
        @NotNull(message = "amount is mandatory on transaction entity")
        @Digits(integer = 15, fraction = 2, message = "amount takes up to 15 digits and up to 2 decimal places")
        BigDecimal amount,
        @NotNull(message = "date is mandatory on transaction entity")
        LocalDateTime dateTime,
        @NotNull(message = "financialType is mandatory on transaction entity")
        FinancialType financialType,
        @NotNull(message = "category is mandatory on transaction entity")
        Long categoryId,
        Long subcategoryId,
        @NotNull(message = "user is mandatory on transaction entity")
        Long userId,
        @NotNull(message = "supplier is mandatory on transaction entity")
        Long supplierId) {

}