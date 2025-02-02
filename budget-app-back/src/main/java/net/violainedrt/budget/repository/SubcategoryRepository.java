package net.violainedrt.budget.repository;

import net.violainedrt.budget.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
}
