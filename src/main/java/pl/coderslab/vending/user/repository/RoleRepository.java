package pl.coderslab.vending.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.vending.user.entity.Role;
import pl.coderslab.vending.user.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long > {
     Role findByName(String name);
}