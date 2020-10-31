package pl.coderslab.vending.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.vending.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository< User, Long > {
    User findByEmail(String email);
}