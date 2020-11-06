package pl.coderslab.vending.machine.entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slot_config")
public class SlotConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
