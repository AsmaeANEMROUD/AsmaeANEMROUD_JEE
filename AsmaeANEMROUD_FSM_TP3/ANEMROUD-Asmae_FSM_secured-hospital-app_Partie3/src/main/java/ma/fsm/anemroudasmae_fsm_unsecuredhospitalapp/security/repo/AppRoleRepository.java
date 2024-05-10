package ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.security.repo;

import ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
