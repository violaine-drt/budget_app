package net.violainedrt.budget.infrastructure.repository;

import net.violainedrt.budget.infrastructure.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
}
