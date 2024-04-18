package ma.fsm.anemroudasmae_jpafsm.repositories;

import ma.fsm.anemroudasmae_jpafsm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);
}
