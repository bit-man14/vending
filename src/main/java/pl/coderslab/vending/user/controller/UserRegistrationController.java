package pl.coderslab.vending.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.vending.user.dto.UserRegistrationDto;
import pl.coderslab.vending.user.entity.User;
import pl.coderslab.vending.user.service.UserService;

import javax.validation.Valid;

@SuppressWarnings("ALL")
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    
    @Autowired
    private UserService userService;
    
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
    
    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }
    
    @PostMapping
    public String registerUserAccount( @ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {
        
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", "duplicated.email");
            return "registration";
        }
        
        if (result.hasErrors()) {
            // logger
            return "registration";
        }
        
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
