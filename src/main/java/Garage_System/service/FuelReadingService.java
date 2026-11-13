package Garage_System.service;

import Garage_System.DTO.RequestDTO.FuelReadingDetailsRequestDTO;
import Garage_System.DTO.ResponseDTO.FuelReadingDetailsResponseDTO;
import Garage_System.DTO.ResponseDTO.FuelReadingResponseDTO;

public interface FuelReadingService {

    FuelReadingResponseDTO saveInReading(Long jobCardId, FuelReadingDetailsRequestDTO request);

    FuelReadingResponseDTO saveOutReading(Long jobCardId, FuelReadingDetailsRequestDTO request);

    FuelReadingResponseDTO getFuelReadingByJobCardId(Long jobCardId);
}
