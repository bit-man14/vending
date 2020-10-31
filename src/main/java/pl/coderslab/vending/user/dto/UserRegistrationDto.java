package pl.coderslab.vending.user.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
    
    @NotEmpty
    private String name;
   
    @NotEmpty
    private String password;
    
    @NotEmpty
    private String confirmPassword;
    
    @Email
    @NotEmpty
    private String email;
    
    @Email
    @NotEmpty
    private String confirmEmail;
    
   
}
