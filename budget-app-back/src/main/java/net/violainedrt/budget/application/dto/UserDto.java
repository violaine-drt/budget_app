package net.violainedrt.budget.application.dto;

import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder(toBuilder = true)
public record UserDto(
        Long id,
        String name,
        String email,
        String password,
        BigDecimal userBalance,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime lastLogin) {
}
