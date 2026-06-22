package Garage_System.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDTO {
    private Long vehicleId;
    private Long customerId;
    private String model;
    private String companyName;
    private String vehicleNumber;
    private String chassisNumber;
    private String engineNumber;
    private Integer odometer;
}
