package net.violainedrt.budget.infrastructure.repository;

import net.violainedrt.budget.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
