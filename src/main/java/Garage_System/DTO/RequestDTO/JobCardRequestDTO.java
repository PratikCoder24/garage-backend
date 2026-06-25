package Garage_System.DTO.RequestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardRequestDTO {
    @NotNull(message = "Vehicle id is required")
    @Positive(message = "Vehicle id must be positive")
    private Long vehicleId;

    @NotBlank(message = "condition of vehicle is required")
    private String condition;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;
}
