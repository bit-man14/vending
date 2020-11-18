package pl.coderslab.vending.user.controller;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.vending.user.dto.UserRegistrationDto;
import pl.coderslab.vending.user.entity.User;
import pl.coderslab.vending.user.service.UserService;
import pl.coderslab.vending.user.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
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
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users";
    }

//    @PostMapping("/edituser/{id}")
//    public String editUserSave(@ModelAttribute("user") User newUser, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "edituserform";
//        }
//        userService.addUser(newUser);
//        return "users";
//    }

    @GetMapping("/edituser/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edituserform";
    }
    @PostMapping("/edituser")
    public String registerUserAccount(@Valid UserRegistrationDto user,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "edituserform";
        }

        userService.save(user);
        return "redirect:/users";
    }
}