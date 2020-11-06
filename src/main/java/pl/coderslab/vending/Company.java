package pl.coderslab.vending;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;

@Setter
@Getter
public class Company {
    private  String companyName="Barbara Kalwasińska";
    private String NIP="699-168-88-15";
    private String REGON="380047270";
}
