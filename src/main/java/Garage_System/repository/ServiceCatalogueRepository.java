package Garage_System.repository;

import Garage_System.entities.ServiceCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCatalogueRepository extends JpaRepository<ServiceCatalogue,Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name,Long id);
}
