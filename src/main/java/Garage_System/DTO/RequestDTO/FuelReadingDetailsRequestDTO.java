package Garage_System.DTO.RequestDTO;

import Garage_System.Enum.MeterStatus;
import Garage_System.Enum.ReadingMode;
import Garage_System.Enum.ReserveStatus;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuelReadingDetailsRequestDTO {

    @NotNull(message = "Reading mode is required")
    private ReadingMode readingMode;

    @DecimalMin(value = "0.00", message = "Fuel level cannot be less than 0")
    @DecimalMax(value = "100.00", message = "Fuel level cannot exceed 100")
    private BigDecimal fuelLevel;

    @NotNull(message = "Meter status is required")
    private MeterStatus meterStatus;

    @NotNull(message = "Reserve status is required")
    private ReserveStatus reserveStatus;
}
