package pl.coderslab.vending.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.vending.machine.entity.SlotConfig;

import java.util.List;

public interface SlotRepository extends JpaRepository<SlotConfig, Long> {
    @Query("select s from SlotConfig s where s.machine_id = ?1")
    List<SlotConfig> findByMachine_idAndActive(Long machine_id);
//    @Query("select s from SlotConfig s where s.machine_id = ?1 and s.isActive = ?2")
//    List<SlotConfig> findByMachine_idAndActive(Long machine_id, boolean isActive);
}
