package net.violainedrt.budget.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.violainedrt.budget.entity.Category;
import net.violainedrt.budget.entity.Type;
import net.violainedrt.budget.entity.User;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private String description;
    private String supplier;
    private Double amount;
    private Date date;
    private Category category;
    private Type type;
    private User user;
}
