package Garage_System.DTO.RequestDTO;

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
public class AddServiceToJobCardRequestDTO {
    @NotNull(message = "Service id is required!")
    @Positive(message = "service id must be positive")
    private Long serviceId;

    @PositiveOrZero(message = "Labour fee must be positive")
    private Double fee;
}
