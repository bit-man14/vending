package pl.coderslab.vending.user.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor

@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String name;
    
    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

}