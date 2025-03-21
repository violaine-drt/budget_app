package net.violainedrt.budget.application.dto.user;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder(toBuilder = true)
public record UpdateUserDto(
        String name,
        String email,
        String password,
        BigDecimal userBalance,
        LocalDateTime lastLogin
        ) {
}