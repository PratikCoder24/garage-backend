package Garage_System.DTO.RequestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCatalogueRequestDTO {
    @NotBlank(message = "service name is required")
    private String serviceName;

    @NotNull(message = "service charge is required")
    @PositiveOrZero(message = "service charge must be positive")
    private Integer serviceCharge;
}
