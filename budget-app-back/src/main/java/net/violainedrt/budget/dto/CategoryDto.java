package net.violainedrt.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import net.violainedrt.budget.entity.User;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String categoryName;
    private String colorCode;
    private Boolean isFlagged;
    private Boolean isDefault;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
