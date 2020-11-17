package pl.coderslab.vending.machine.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.machine.entity.SlotConfig;
import pl.coderslab.vending.machine.repository.MachineRepository;
import pl.coderslab.vending.machine.repository.SlotRepository;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;
    private final SlotRepository slotRepository;
    private static final Logger log = LogManager.getLogger(MachineServiceImpl.class);

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
    public void saveSlot(long mach_id) {
        Machine machine = getMachine(mach_id);
        int sh = machine.getShelves();
        int sl = machine.getSlotsPerShelf();
        int slNo=0;
        SlotConfig slotConfig;
        for (int i = 1; i <= sh; i++) {
            for (int j = 0; j < sl; j++) {
                slNo=i*10+j;
                slotConfig = new SlotConfig();
                slotConfig.setSlotNo(slNo);
                slotConfig.setSpiralSize(6);
                slotConfig.setActive(true);
                System.out.println(slotConfig.toString());
                log.debug(slotConfig.toString());

                machineRepository.save(machine);
                slotRepository.save(slotConfig);
            }

        }
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
