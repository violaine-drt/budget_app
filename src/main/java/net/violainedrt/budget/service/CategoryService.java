package net.violainedrt.budget.service;

import net.violainedrt.budget.dto.CategoryDto;
import net.violainedrt.budget.dto.TypeDto;
import net.violainedrt.budget.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory (CategoryDto categoryDto);
}
