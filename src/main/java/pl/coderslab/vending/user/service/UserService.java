package pl.coderslab.vending.user.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.vending.user.dto.UserRegistrationDto;
import pl.coderslab.vending.user.entity.User;

public interface UserService extends UserDetailsService {
    
    User findByEmail(String email);
    
    User save(UserRegistrationDto registration);
}
