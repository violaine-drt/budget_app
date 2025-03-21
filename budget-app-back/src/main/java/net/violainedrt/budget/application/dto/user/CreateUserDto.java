package net.violainedrt.budget.application.dto.user;

import lombok.Builder;

import java.math.BigDecimal;


@Builder(toBuilder = true)
public record CreateUserDto(
        String name,
        String email,
        String password,
        BigDecimal userBalance) {
}
