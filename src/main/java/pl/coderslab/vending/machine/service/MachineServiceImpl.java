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

    //    public void saveEdit(Machine machine) {
//        machineRepository.save(machine);
//    }
    @Override
    public boolean saveSlot(long mach_id) {
        Machine machine = getMachine(mach_id);
        SlotConfig slotConfig;

        int sh = machine.getShelves();
        int sl = machine.getSlotsPerShelf();

        if (sh == 0 || sl == 0) {
            return false;
        }
        if (sh == 1) {//drinks
            for (int j = 1; j <= sl; j++) {
                slotConfig = new SlotConfig();
                slotConfig.setSlotNo(j);
                slotConfig.setSpiralSize(0);//default value
                slotConfig.setActive(true);
                slotConfig.setMachine_id(mach_id);
                slotRepository.save(slotConfig);
            }
        } else {//spirals
            int slNo = 0;
            for (int i = 1; i <= sh; i++) {
                for (int j = 0; j < sl; j++) {
                    slNo = i * 10 + j;
                    slotConfig = new SlotConfig();
                    slotConfig.setSlotNo(slNo);
                    slotConfig.setSpiralSize(6);//default value
                    slotConfig.setActive(true);
                    slotConfig.setMachine_id(mach_id);
                    slotRepository.save(slotConfig);
                }
            }
        }

        return true;
    }

    @Override
    @Transactional
    public Machine getMachine(long id) throws ResourceNotFoundException {
        return machineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.valueOf(id)));
    }

    @Override
    public void deleteById(Long id) {
        machineRepository.deleteById(id);
    }


}
