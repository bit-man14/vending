package pl.coderslab.vending.files.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vending.files.entity.File;

public interface FileRepository extends JpaRepository<File,Integer> {
}
