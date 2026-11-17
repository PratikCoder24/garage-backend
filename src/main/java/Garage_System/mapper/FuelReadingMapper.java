package Garage_System.mapper;

import Garage_System.DTO.RequestDTO.FuelReadingDetailsRequestDTO;
import Garage_System.DTO.ResponseDTO.FuelReadingDetailsResponseDTO;
import Garage_System.DTO.ResponseDTO.FuelReadingResponseDTO;
import Garage_System.entities.FuelReading;
import Garage_System.entities.FuelReadingDetails;

import java.time.LocalDateTime;

public class FuelReadingMapper {

    public static FuelReadingResponseDTO mapToDTO(FuelReading fuelReading){
        return new FuelReadingResponseDTO(
                fuelReading.getId(),
                fuelReading.getJobCard().getId(),
                mapDetailsToDTO(fuelReading.getInReading())
        );
    }

    private static FuelReadingDetailsResponseDTO mapDetailsToDTO(FuelReadingDetails details){
        if(details == null){
            return null;
        }

        return new FuelReadingDetailsResponseDTO(
          details.getReadingMode(),
          details.getFuelLevel(),
          details.getMeterStatus(),
          details.getReserveStatus(),
          details.getRecordedAt()
        );
    }

    public static FuelReadingDetails mapToEntity(
            FuelReadingDetailsRequestDTO request) {

        FuelReadingDetails details = new FuelReadingDetails();

        details.setReadingMode(request.getReadingMode());
        details.setFuelLevel(request.getFuelLevel());
        details.setMeterStatus(request.getMeterStatus());
        details.setReserveStatus(request.getReserveStatus());
        details.setRecordedAt(LocalDateTime.now());

        return details;
    }

}
