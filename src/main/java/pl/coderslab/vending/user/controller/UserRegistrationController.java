package pl.coderslab.vending.user.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private static final Logger log = LogManager.getLogger(UserRegistrationController.class);

    @Autowired
    private UserServiceImpl userServiceImpl;


    @GetMapping
    public String showRegistrationForm(Model model) {
        UserRegistrationDto newUser = new UserRegistrationDto();
        model.addAttribute("user", newUser);
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto userDto,
                                      BindingResult result) {
        if (result.hasErrors()) {
            log.debug("Binding error");
            return "registration";
        }
        User existing = userServiceImpl.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", "duplicated_email");
            return "registration";
        }


        userServiceImpl.save(userDto);
        return "redirect:/registration?success";
    }


}
