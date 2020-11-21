package pl.coderslab.vending.product.entity;

import lombok.*;
import pl.coderslab.vending.machine.entity.Machine;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "name", length = 100, nullable = false)
    @NotEmpty
    @Size(min = 3)
    private String name;


    @Min(5)
    @Max(19)
    private int forSpiralSize;

    @DecimalMin(value = "0.10")
    @DecimalMax(value = "10.00")
    @Digits(integer = 2, fraction = 2)
    private Double price;

    @OneToOne
    @JoinColumn(name = "packshape_id")
    private PackShape packShape;//bottle, can , pouch, bar, box

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForSpiralSize() {
        return forSpiralSize;
    }

    public void setForSpiralSize(int forSpiralSize) {
        this.forSpiralSize = forSpiralSize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
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

    public PackShape getPackShape() {
        return packShape;
    }

    public void setPackShape(PackShape packShape) {
        this.packShape = packShape;
    }
}
