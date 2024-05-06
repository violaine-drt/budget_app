package net.violainedrt.budget.repository;

import net.violainedrt.budget.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
//Ici, l'interface va hériter de totues les méthodes CRUD de la JpaRepository interface
public interface TypeRepository extends JpaRepository<Type, Long> {

}
