package pl.coderslab.vending.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.vending.user.entity.Role;
import pl.coderslab.vending.user.entity.User;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long > {
     Role findByName(String name);

     @Query(value = "SELECT role_id FROM users_roles WHERE user_id = ?1",
             nativeQuery = true)
     List<Long> findRolesIdByUserId(Long user_id);

}