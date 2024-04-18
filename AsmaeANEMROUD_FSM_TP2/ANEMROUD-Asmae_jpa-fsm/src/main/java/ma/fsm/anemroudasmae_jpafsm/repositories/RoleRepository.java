package ma.fsm.anemroudasmae_jpafsm.repositories;

import ma.fsm.anemroudasmae_jpafsm.entities.Role;
import ma.fsm.anemroudasmae_jpafsm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
