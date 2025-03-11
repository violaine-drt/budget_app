package net.violainedrt.budget.infrastructure.repository;

import net.violainedrt.budget.infrastructure.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
