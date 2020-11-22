package pl.coderslab.vending.machine.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slot_config")
public class SlotConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int slotNo;
    private int spiralSize;
    private boolean isActive;
    private Long machine_id;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

//    @ManyToOne
//    @JoinColumn(name = "machine_id")
//    private Machine machine;

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

}
