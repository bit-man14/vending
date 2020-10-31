package pl.coderslab.vending.machine.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.machine.repository.MachineRepository;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;
    
    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }
    
    @Override
    @Transactional
    public List<Machine> getMachines() {
        return machineRepository.findAll();
    }
    
    @Override
    @Transactional
    public void saveMachine(Machine machine) {
        machineRepository.save(machine);
    }
    
    @Override
    @Transactional
    public Machine getMachine(long id) throws ResourceNotFoundException {
        return machineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.valueOf(id)));
    }
    
    @Override
    @Transactional
    public void deleteMachine(long id) throws ResourceNotFoundException {
        machineRepository.deleteById(id);
    }
}
