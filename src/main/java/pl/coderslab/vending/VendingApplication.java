package pl.coderslab.vending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.coderslab.vending.machine.service.MachineServiceImpl;

@SpringBootApplication
public class VendingApplication {
    
    public static void main(String[] args) {
        
        SpringApplication.run(VendingApplication.class, args);

    }
    
    
}
