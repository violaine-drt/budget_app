package net.violainedrt.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.violainedrt.budget.entity.Category;
import net.violainedrt.budget.entity.Subcategory;
import net.violainedrt.budget.entity.User;
import net.violainedrt.budget.enums.FinancialType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private String description;
    private String counterparty;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private FinancialType financialType;
    private Category category;
    private Subcategory subcategory;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
