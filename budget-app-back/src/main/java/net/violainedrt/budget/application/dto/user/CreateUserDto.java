package net.violainedrt.budget.application.dto.user;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;


@Builder(toBuilder = true)
public record CreateUserDto(
        @NotNull(message = "name is mandatory on user entity")
        @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
        String name,
        @NotNull(message = "email is mandatory on user entity")
        @Size(min = 1, max = 255, message = "Email must be between 3 and 250 characters")
        String email,
        @NotNull(message = "password is mandatory on user entity")
        @Size(min = 1, max = 255, message = "Password must be between 1 and 255 characters")
        String password,
        @NotNull(message = "balance is mandatory on user entity")
        @Digits(integer = 15, fraction = 2, message = "balance takes up to 15 digits and up to 2 decimal places")
        BigDecimal userBalance) {
}
