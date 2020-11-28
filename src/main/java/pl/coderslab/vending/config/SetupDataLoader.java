package pl.coderslab.vending.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.vending.product.entity.Product;
import pl.coderslab.vending.user.entity.Role;
import pl.coderslab.vending.user.entity.User;
import pl.coderslab.vending.user.repository.RoleRepository;
import pl.coderslab.vending.user.repository.UserRepository;
import pl.coderslab.vending.product.repository.ProductRepository;

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
    private ProductRepository productRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        //createRoleIfNotFound("ADMIN");
        //createRoleIfNotFound("EDITOR");
        //createRoleIfNotFound("READER");
        //createRoleIfNotFound("WIZZARD");

        //Role adminRole = roleRepository.findByName("ADMIN");
        Role readerRole = roleRepository.findByName("READER");
        User user = new User();
        Product product = new Product();
        user.setName("TestUser");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(readerRole));
        user.setActive(true);
        userRepository.save(user);
        //insert product that will be default for generated slots
//        product.setId(1L);
//        product.setName("Empty");
//        product.setPrice(0.1);
//        productRepository.save(product);
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
