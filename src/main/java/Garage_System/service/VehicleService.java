package Garage_System.service;

import Garage_System.DTO.RequestDTO.VehicleRequestDTO;
import Garage_System.DTO.ResponseDTO.VehicleResponseDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleResponseDTO> getAllVehicles();

    VehicleResponseDTO addVehicle(VehicleRequestDTO request);

    VehicleResponseDTO updateVehicle(Long id,VehicleRequestDTO request);

    VehicleResponseDTO searchVehicle(String vehicleNumber);

    void deleteVehicle(Long id);
}
