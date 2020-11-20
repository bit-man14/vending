package pl.coderslab.vending.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vending.product.entity.PackShape;

public interface PackRepository extends JpaRepository<PackShape,Long> {
}
