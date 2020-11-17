package pl.coderslab.vending.machine.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.vending.machine.entity.Machine;
import pl.coderslab.vending.machine.entity.SlotConfig;
import pl.coderslab.vending.machine.service.MachineService;
import pl.coderslab.vending.machine.service.MachineServiceImpl;

@Controller
@RequestMapping("/mach")
public class MachineController {
    private static final Logger log = LogManager.getLogger(MachineController.class);

    private MachineService machineService;
    private MachineServiceImpl machineServiceImpl;

    public MachineController(MachineServiceImpl machineServiceImpl) {
        this.machineServiceImpl = machineServiceImpl;
    }

//    @GetMapping
//    public String getMachines() {
//        return "index";
//    }
//
//    @GetMapping("/login")
//    public String login(Model model) {
//        return "login";
//    }
//
//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }


    @GetMapping("/saveslot/{id}")
    @ResponseBody
    public String saveSlot(@PathVariable Long id, Model model) {

        machineServiceImpl.saveSlot(id);
        return "Saved slots for machine id=" + id;
    }

}
