package pl.coderslab.vending.product.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

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
    private String name;
    private String packShape;
    private Double price;
    private int size;

    
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
