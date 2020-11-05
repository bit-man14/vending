package pl.coderslab.vending;

import lombok.Data;
import org.hibernate.validator.constraints.pl.NIP;

@Data
public class Company {
    private  String companyName="Barbara Kalwasińska";
    private String NIP="699-168-88-15";
    private String REGON="380047270";
}
