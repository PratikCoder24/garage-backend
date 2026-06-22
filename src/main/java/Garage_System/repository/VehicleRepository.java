package Garage_System.repository;

import Garage_System.entities.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles,Long> {
    boolean existsByVehicleNumber(String vehicleNumber);
    boolean existsByVehicleNumberAndIdNot(String vehicleNumber,Long id);
    boolean existsByChassisNumber(String chassisNumber);
    boolean existsByChassisNumberAndIdNot(String chassisNumber,Long id);
    Optional<Vehicles> findByVehicleNumber(String vehicleNumber);

}
