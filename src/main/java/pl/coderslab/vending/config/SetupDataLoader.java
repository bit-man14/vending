package pl.coderslab.vending.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.vending.user.entity.Role;
import pl.coderslab.vending.user.entity.User;
import pl.coderslab.vending.user.repository.RoleRepository;
import pl.coderslab.vending.user.repository.UserRepository;

import java.util.Arrays;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("USER");
        createRoleIfNotFound("READER");
        createRoleIfNotFound("WIZZARD");

        //Role adminRole = roleRepository.findByName("ADMIN");
        Role readerRole = roleRepository.findByName("READER");
        User user = new User();
        user.setName("TestUser");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(readerRole));
        user.setActive(true);
        userRepository.save(user);

        alreadySetup = true;
    }


    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
