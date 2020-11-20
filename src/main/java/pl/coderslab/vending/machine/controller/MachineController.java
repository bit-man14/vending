package pl.coderslab.vending.machine.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.machine.entity.SlotConfig;
import pl.coderslab.vending.machine.service.MachineService;
import pl.coderslab.vending.machine.service.MachineServiceImpl;
import pl.coderslab.vending.user.entity.User;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/machines")
public class MachineController {
    private static final Logger log = LogManager.getLogger(MachineController.class);

    private MachineService machineService;
    private MachineServiceImpl machineServiceImpl;

    public MachineController(MachineServiceImpl machineServiceImpl) {
        this.machineServiceImpl = machineServiceImpl;
    }

    @GetMapping("/machines")
    public String allMachines(Model model) {
        List<Machine> machines = machineServiceImpl.getMachines();
        model.addAttribute("machines", machines);
        return "machines";
    }
    @GetMapping("/deletemachine/{id}")
    public String delete(@PathVariable Long id) {
        machineServiceImpl.deleteById(id);
        return "redirect:/machines";
    }
    @GetMapping("/editmachine/{id}")
    public String editMachineForm(@PathVariable Long id, Model model) {
        Machine machine = machineServiceImpl.getMachine(id);
        model.addAttribute("machine", machine);
        return "editmachineform";
    }

    @PostMapping("/editmachine")
    public String editMachine(@Valid Machine machine, BindingResult result) {
        if (result.hasErrors()) {
            return "editmachineform";
        }

        machineServiceImpl.saveMachine(machine);
        return "redirect:/machines?success";
    }

    @GetMapping("/saveslot/{id}")
    @ResponseBody
    public String saveSlot(@PathVariable Long id, Model model) {

        machineServiceImpl.saveSlot(id);
        return "Saved slots for machine id=" + id;
    }
    @GetMapping("/addmachine")
    public String addBookForm(Model model) {
        model.addAttribute("machine", new Machine());
        return "addmachineform";
    }

    @PostMapping("/addmachine")
    public String add(@ModelAttribute("machine") Machine machine, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addmachineform";
        }
        machineServiceImpl.saveMachine(machine);
        return "redirect:/machines?success";
    }
}
