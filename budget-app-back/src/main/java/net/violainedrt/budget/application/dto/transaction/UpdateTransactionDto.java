package net.violainedrt.budget.application.dto.transaction;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record UpdateTransactionDto (
        @Size(max = 255, message = "Description must be <= 255 characters")
        String description,
        @Digits(integer = 15, fraction = 2, message = "amount takes up to 15 digits and up to 2 decimal places")
        BigDecimal amount,
        LocalDateTime dateTime,
        Long categoryId,
        Long subcategoryId,
        Long supplierId) {

}