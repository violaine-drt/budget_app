package net.violainedrt.budget.infrastructure.repository;

import net.violainedrt.budget.infrastructure.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}
