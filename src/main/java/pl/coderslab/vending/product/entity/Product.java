package pl.coderslab.vending.product.entity;

import lombok.*;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "name", length = 100, nullable = false)
    @NotBlank
    @Size(min = 3)
    private String name;
    private String packShape;//bottle, can , pouch, bar, box

    @Min(5)
    @Max(19)
    private int forSpiralSize;

    @DecimalMin(value = "0.10")
    @DecimalMax(value = "10.00")
    @Digits(integer=2, fraction=2)
    private Double price;


    @ManyToMany(mappedBy = "products")
    private List<Machine> machines;

    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
  
    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }
    
    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }
}
