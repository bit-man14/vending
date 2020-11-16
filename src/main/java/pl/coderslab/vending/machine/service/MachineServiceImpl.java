package pl.coderslab.vending.machine.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.machine.entity.SlotConfig;
import pl.coderslab.vending.machine.repository.MachineRepository;
import pl.coderslab.vending.machine.repository.SlotRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;
    private final SlotRepository slotRepository;

    public MachineServiceImpl(MachineRepository machineRepository, SlotRepository slotRepository) {
        this.machineRepository = machineRepository;
        this.slotRepository = slotRepository;
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

    @Transactional
    public void saveSlotConfig(long mach_id) {
        Machine machine=getMachine(mach_id);
        int sh = machine.getShelves();
        int sl = machine.getSlotsPerShelf();
        SlotConfig slotConfig;
        for (int i = 0; i < sh; i++) {
            for (int j = 1; j <= sl; j++) {
                slotConfig = new SlotConfig();
                slotConfig.setSlotNo(j*10+i);
                slotConfig.setSpiralSize(6);
                slotConfig.setActive(true);
                slotRepository.save(slotConfig);
            }
        }
    }
}
