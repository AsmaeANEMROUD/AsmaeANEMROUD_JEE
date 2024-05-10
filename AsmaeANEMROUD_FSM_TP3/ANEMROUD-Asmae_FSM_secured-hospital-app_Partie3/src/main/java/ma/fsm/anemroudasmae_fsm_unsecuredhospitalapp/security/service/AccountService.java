package ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.security.service;

import ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.security.entities.AppRole;
import ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username, String password, String email, String confirmPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username);
}
