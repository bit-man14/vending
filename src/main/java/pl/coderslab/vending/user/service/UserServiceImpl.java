package pl.coderslab.vending.user.service;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.vending.user.dto.UserRegistrationDto;
import pl.coderslab.vending.user.entity.Role;
import pl.coderslab.vending.user.entity.User;
import pl.coderslab.vending.user.repository.RoleRepository;
import pl.coderslab.vending.user.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration) {
        User user = new User();
        //Role role = new Role();
        user.setName(registration.getName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setActive(true);
        Role readerRole = roleRepository.findByName("READER");
        user.setRoles(Arrays.asList(readerRole));

        return userRepository.save(user);

    }

    @Override
    public void saveEdit(User user) {


        userRepository.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> userById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid user email or password.");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.getIsActive(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }


    @Transactional
    public User getUser(long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.valueOf(id)));
    }
}
