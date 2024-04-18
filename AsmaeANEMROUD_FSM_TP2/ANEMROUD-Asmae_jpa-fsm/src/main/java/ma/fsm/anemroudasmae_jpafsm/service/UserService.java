package ma.fsm.anemroudasmae_jpafsm.service;

import ma.fsm.anemroudasmae_jpafsm.entities.Role;
import ma.fsm.anemroudasmae_jpafsm.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String userName, String password);
}
