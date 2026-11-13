package Garage_System.repository;

import Garage_System.entities.FuelReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelReadingRepository extends JpaRepository<FuelReading, Long> {

    Optional<FuelReading> findByJobCardId(Long jobCardId);

    boolean existsByJobCardId(Long jobCardId);
}