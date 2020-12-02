package pl.coderslab.vending.machine.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.machine.entity.SlotConfig;
import pl.coderslab.vending.machine.service.MachineService;
import pl.coderslab.vending.machine.service.MachineServiceImpl;
import pl.coderslab.vending.product.entity.Product;
import pl.coderslab.vending.product.service.ProductServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/machines")
public class MachineController {
    private static final Logger log = LogManager.getLogger(MachineController.class);

    private MachineService machineService;
    private MachineServiceImpl machineServiceImpl;
    private ProductServiceImpl productServiceImpl;

    public MachineController(MachineService machineService, MachineServiceImpl machineServiceImpl, ProductServiceImpl productServiceImpl) {
        this.machineService = machineService;
        this.machineServiceImpl = machineServiceImpl;
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/machines")
    public String allMachines(Model model) {
        List<Machine> machines = machineServiceImpl.getMachines();
        model.addAttribute("machines", machines);
        return "machines";
    }

    @GetMapping("/slots/{mach_id}")
    public String slotsByMachine(@PathVariable Long mach_id, Model model) {
        List<SlotConfig> slotConfigList = machineServiceImpl.findByMachineId(mach_id);
        Machine machine=machineServiceImpl.getMachine(mach_id);
        //List<Product> products = productServiceImpl.getProducts();

        model.addAttribute("slots", slotConfigList);
        model.addAttribute("machine", machine);
        //model.addAttribute("products", products);
        return "slots";
    }

    @GetMapping("/deletemachine/{id}")
    public String delete(@PathVariable Long id) {
        machineServiceImpl.deleteMachineById(id);
        return "redirect:/machines";
    }

    @GetMapping("/editmachine/{id}")
    public String editMachineForm(@PathVariable Long id, Model model) {
        Machine machine = machineServiceImpl.getMachine(id);
        List<SlotConfig> slots=machineServiceImpl.findByMachineId(id);//slots from current machine
        model.addAttribute("machine", machine);
        model.addAttribute("slots", slots);
        return "editmachineform";
    }

    @PostMapping("/editmachine")
    public String editMachine(@Valid Machine machine, BindingResult result) {
        if (result.hasErrors()) {
            return "editmachineform";
        }
//        slotConfig.setMachine_id(machine.getId());//test
//        slotConfig.setSlotNo(slotConfig.getSlotNo());
//        slotConfig.setSpiralSize(slotConfig.getSpiralSize());
        machine.setId(machine.getId());//test
        //machineServiceImpl.saveEditSlot(slotConfig);//test
        machineServiceImpl.saveMachine(machine);

        return "redirect:/machines?success";
    }

    @GetMapping("/saveslot/{id}")
    @ResponseBody
    public String saveSlot(@PathVariable Long id, Model model) {

        machineServiceImpl.deleteSlotByMachineId(id);
        if (machineServiceImpl.saveSlot(id)) {
            return "Created empty slots for machine id = " + id;
        } else {
            return "Missing data to create slots for id = " + id;
        }

    }

    @GetMapping("/addmachine")
    public String addBookForm(Model model) {
        model.addAttribute("machine", new Machine());
        return "addmachineform";
    }

    @PostMapping("/addmachine")
    public String add(@ModelAttribute("machine") @Valid Machine machine, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addmachineform";
        }
        machineServiceImpl.saveMachine(machine);
        return "redirect:/machines?success";
    }

    @GetMapping("/editslot/{id}/{mach_id}")
    public String editSlotForm(@PathVariable Long id, @PathVariable Long mach_id, Model model) {
        SlotConfig slotConfig = machineServiceImpl.getSlot(id);
        Machine machine = machineServiceImpl.getMachine(mach_id);

        List<Product> products = productServiceImpl.getProducts();
        model.addAttribute("slot", slotConfig);
        model.addAttribute("products", products);
        model.addAttribute("machine", machine);
        return "editslotform";
    }

    @PostMapping("/editslot/{mach_id}")
    public String editSlot(@PathVariable Long mach_id,@Valid SlotConfig slotConfig, BindingResult result) {
        if (result.hasErrors()) {
            return "editslotform";
        }
        slotConfig.setMachine_id(mach_id);
        machineServiceImpl.saveEditSlot(slotConfig);
        return "redirect:/slots/"+mach_id+"?success";
    }
}
