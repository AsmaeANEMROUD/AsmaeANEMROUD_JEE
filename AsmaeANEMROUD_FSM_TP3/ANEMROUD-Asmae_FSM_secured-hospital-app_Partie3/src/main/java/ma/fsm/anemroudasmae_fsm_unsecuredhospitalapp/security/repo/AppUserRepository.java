package ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.security.repo;

import ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
