package pl.coderslab.vending.user.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NotEmpty
    @Size(min = 3)
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    private boolean active;


    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(Long id, @NotBlank @Size(min = 5) String name, String password, @NotBlank @Email(message = "Please enter a valid e-mail address") String email, boolean active, LocalDateTime createdOn, LocalDateTime updatedOn, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.active = active;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.roles = roles;
    }

    public User(@NotBlank @Size(min = 5) String name, String password, @NotBlank @Email(message = "Please enter a valid e-mail address") String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    //private Set<Role> roles = new HashSet<>();


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", roles=" + roles +
                '}';
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
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

    public boolean getIsActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // public Set<Role> getRoles() {
//        return roles;
//    }

//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Collection<Role> getRoles() {
        return roles;
    }



}
