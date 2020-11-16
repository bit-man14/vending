package pl.coderslab.vending.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vending.machine.entity.SlotConfig;

public interface SlotRepository extends JpaRepository<SlotConfig,Long>{
}
