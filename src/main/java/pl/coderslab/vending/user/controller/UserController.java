package pl.coderslab.vending.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.vending.user.entity.Role;
import pl.coderslab.vending.user.entity.User;
import pl.coderslab.vending.user.service.RoleService;
import pl.coderslab.vending.user.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    final UserServiceImpl userService;

    final RoleService roleService;

    public UserController(UserServiceImpl userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/deleteuser/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/edituser/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        List<Role> roles = (List<Role>) roleService.getRoles();
        model.addAttribute("allRoles", roles);
        return "edituserform";
    }

    @PostMapping("/edituser")
    public String registerUserAccount(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edituserform";
        }

        userService.saveEdit(user);
        return "redirect:/users?success";
    }

}