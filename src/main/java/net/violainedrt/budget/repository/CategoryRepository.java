package net.violainedrt.budget.repository;

import net.violainedrt.budget.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
