package pl.coderslab.vending.machine.entity;

import lombok.*;
import pl.coderslab.vending.product.entity.Product;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slot_config")
public class SlotConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int slotNo;
    @Min(1)
    @Max(19)
    private int spiralSize;
    private boolean isActive;
    private Long machine_id;
    //private Long product_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public int getSpiralSize() {
        return spiralSize;
    }

    public void setSpiralSize(int spiralSize) {
        this.spiralSize = spiralSize;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    //    @ManyToOne
//    @JoinColumn(name = "machine_id")
//    private Machine machine;
    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "SlotConfig{" +
                "id=" + id +
                ", slotNo=" + slotNo +
                ", spiralSize=" + spiralSize +
                ", isActive=" + isActive +
                '}';
    }

    public Long getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(Long machine_id) {
        this.machine_id = machine_id;
    }

//    public Long getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(Long product_id) {
//        this.product_id = product_id;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
