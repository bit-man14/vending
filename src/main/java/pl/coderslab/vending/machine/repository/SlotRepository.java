package pl.coderslab.vending.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.vending.machine.entity.SlotConfig;

import java.util.List;

public interface SlotRepository extends JpaRepository<SlotConfig, Long> {
    @Query("select s from SlotConfig s where s.machine_id = ?1")
    List<SlotConfig> findByMachineId(Long machine_id);

    //    @Query("select s from SlotConfig s where s.machine_id = ?1 and s.isActive = ?2")
//    List<SlotConfig> findByMachine_idAndActive(Long machine_id, boolean isActive);
//    @Query("select s from SlotConfig s where s.machine_id = ?1")
//    void deleteByMachine_id(Long mach_id);

    @Modifying
    @Transactional
    @Query("delete from SlotConfig s where s.machine_id = ?1")
            int deleteSlotByMachId(Long mach_id);
}
