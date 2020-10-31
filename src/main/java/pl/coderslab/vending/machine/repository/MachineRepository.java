package pl.coderslab.vending.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.vending.machine.entity.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine,Long> {
}
