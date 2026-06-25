package Garage_System.DTO.RequestDTO;

import Garage_System.Enum.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardStatusUpdateRequestDTO {
    @NotNull(message = "Status is required")
    private Status status;
}
