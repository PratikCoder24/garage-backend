package Garage_System.DTO.ResponseDTO;

import Garage_System.Enum.MeterStatus;
import Garage_System.Enum.ReadingMode;
import Garage_System.Enum.ReserveStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuelReadingDetailsResponseDTO {

    private ReadingMode readingMode;
    private BigDecimal fuelLevel;
    private MeterStatus meterStatus;
    private ReserveStatus reserveStatus;
    private LocalDateTime recordedAt;
}