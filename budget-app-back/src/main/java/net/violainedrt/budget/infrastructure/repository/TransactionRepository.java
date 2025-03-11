package net.violainedrt.budget.infrastructure.repository;

import net.violainedrt.budget.infrastructure.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
