package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.VehicleResponseDTO;
import Garage_System.entities.Vehicles;

public class VehicleMapper {
    public static VehicleResponseDTO mapToDTO(Vehicles vehicle){
        return new VehicleResponseDTO(
                vehicle.getId(),
                vehicle.getCustomer().getId(),
                vehicle.getModel(),
                vehicle.getCompany(),
                vehicle.getVehicleNumber(),
                vehicle.getChassisNumber(),
                vehicle.getEngineNumber(),
                vehicle.getOdometer()
        );
    }
}
