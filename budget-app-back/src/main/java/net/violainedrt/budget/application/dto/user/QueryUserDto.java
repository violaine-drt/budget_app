package net.violainedrt.budget.application.dto.user;

import lombok.Builder;

import java.math.BigDecimal;


@Builder(toBuilder = true)
public record QueryUserDto(
        Long id,
        String name,
        String email,
        BigDecimal userBalance)
{
}