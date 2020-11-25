package pl.coderslab.vending.machine.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.machine.entity.SlotConfig;

import java.util.List;

public interface MachineService {
    List<Machine> getMachines();

    void saveMachine(Machine machine);

    boolean saveSlot(long mach_id);//for slot generation

    void saveEditSlot(SlotConfig slotConfig);

    Machine getMachine(long id) throws ResourceNotFoundException;

    SlotConfig getSlot(long id) throws ResourceNotFoundException;

    void deleteMachineById(Long id);

    List<SlotConfig> findByMachine_idAndActive(Long machine_id);
}
