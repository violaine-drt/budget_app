package net.violainedrt.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.violainedrt.budget.entity.Category;
import net.violainedrt.budget.entity.Transaction;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private Category parent;
    private List<Category> children;
    private List<Transaction> transactions;
    private Date createdAt;
    private Date updatedAt;
}
