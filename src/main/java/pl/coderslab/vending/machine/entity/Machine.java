package pl.coderslab.vending.machine.entity;

import lombok.*;
import pl.coderslab.vending.product.entity.Product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "machines")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "name", length = 100, nullable = false)
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    private String serial;
    //@Column(name = "inst_date")
    private Date instDate;
    private int shelves;
    private int slotsPerShelf;
//
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//    private List<Integer> getValues() {
//        return values;
//    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "machines_products",
            joinColumns = @JoinColumn(
                    name = "machine_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id"))
    private Collection<Product> products;


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
