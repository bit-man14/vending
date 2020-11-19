package pl.coderslab.vending.user.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class UserRegistrationDto {

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotEmpty
    private String password;


    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    public UserRegistrationDto(@NotEmpty String name, @Email @NotEmpty String email, @NotEmpty String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;

    }


    public String getConfirmPassword() {
        return confirmPassword;
    }


    public UserRegistrationDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
