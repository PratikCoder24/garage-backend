package Garage_System.DTO.RequestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Vehicle number is required")
    private String vehicleNumber;


    private String chassisNumber;


    private String engineNumber;


    @PositiveOrZero(message = "Odometer must be positive")
    private Integer odometer;

    @NotNull(message = "Customer Id is required")
    @Positive(message = "Id must be positive")
    private Long customerId;
}
