package pl.coderslab.vending.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.vending.user.entity.Role;
import pl.coderslab.vending.user.repository.RoleRepository;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
