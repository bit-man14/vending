package pl.coderslab.vending.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.vending.user.dto.UserRegistrationDto;
import pl.coderslab.vending.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    
    User findByEmail(String email);
    
    User save(UserRegistrationDto registration);
    void saveEdit(User user);

    List<User> allUsers();

    Optional<User> userById(Long id);

    void addUser(User user);// adding by ADMIN

    void deleteById(Long id);

    void update(User user);
}
