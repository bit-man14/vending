package pl.coderslab.vending.machine.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import pl.coderslab.vending.machine.entity.Machine;

import java.util.List;

public interface MachineService {
    List<Machine> getMachines();
    
    void saveMachine(Machine machine);
    
    Machine getMachine(long id) throws ResourceNotFoundException;
    
    void deleteMachine(long id) throws ResourceNotFoundException;
}
