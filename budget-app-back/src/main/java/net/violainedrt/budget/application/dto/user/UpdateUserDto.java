package net.violainedrt.budget.application.dto.user;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder(toBuilder = true)
public record UpdateUserDto(
        @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
        String name,
        @Size(min = 1, max = 255, message = "Email must be between 3 and 250 characters")
        String email,
        @Size(min = 1, max = 255, message = "Password must be between 1 and 255 characters")
        String password,
        @Digits(integer = 15, fraction = 2, message = "balance takes up to 15 digits and up to 2 decimal places")
        BigDecimal userBalance,
        LocalDateTime lastLogin
        ) {
}