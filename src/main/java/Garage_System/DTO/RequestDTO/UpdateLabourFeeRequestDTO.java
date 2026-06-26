package Garage_System.DTO.RequestDTO;

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
public class UpdateLabourFeeRequestDTO {
    @NotNull(message = "Labour fee is required")
    @PositiveOrZero(message = "Labour fee must be positive")
    private Double labourFee;
}
