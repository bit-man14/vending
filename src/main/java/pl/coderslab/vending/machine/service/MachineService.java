package pl.coderslab.vending.machine.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import pl.coderslab.vending.machine.entity.Machine;

import java.util.List;

public interface MachineService {
    List<Machine> getMachines();
    
    void saveMachine(Machine machine);
    void saveSlot(long mach_id);

    Machine getMachine(long id) throws ResourceNotFoundException;

    void deleteById(Long id);
}
