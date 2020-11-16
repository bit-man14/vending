package pl.coderslab.vending.machine.entity;

import lombok.*;
import pl.coderslab.vending.product.entity.Product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "machines")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    private String serial;
    //@Column(name = "inst_date")
    private Date instDate;
    private int shelves;
    private int slotsPerShelf;
    @OneToMany
    private List<SlotConfig> slots=new ArrayList<>();



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "machines_products",
            joinColumns = @JoinColumn(
                    name = "machine_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id"))
    private List<Product> products;


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

    private void testConfig(){
         int shelves=5;
         int slotsPerShelf=8;
        SlotConfig slotConfig=new SlotConfig();

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getInstDate() {
        return instDate;
    }

    public void setInstDate(Date instDate) {
        this.instDate = instDate;
    }

    public int getShelves() {
        return shelves;
    }

    public void setShelves(int shelves) {
        this.shelves = shelves;
    }

    public int getSlotsPerShelf() {
        return slotsPerShelf;
    }

    public void setSlotsPerShelf(int slotsPerShelf) {
        this.slotsPerShelf = slotsPerShelf;
    }

    public List<SlotConfig> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotConfig> slots) {
        this.slots = slots;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
}
