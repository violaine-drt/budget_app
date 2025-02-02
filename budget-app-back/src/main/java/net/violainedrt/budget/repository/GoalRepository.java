package net.violainedrt.budget.repository;

import net.violainedrt.budget.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}
