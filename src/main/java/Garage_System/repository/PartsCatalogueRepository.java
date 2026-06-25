package Garage_System.repository;

import Garage_System.entities.PartsCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsCatalogueRepository extends JpaRepository<PartsCatalogue,Long> {
    boolean existsByPartName(String partsName);
    boolean existsByPartNameAndIdNot(String partName,Long id);
}
