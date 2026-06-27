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
public class AddPartsToJobCardRequestDTO {
    @NotNull(message = "Part id is required")
    @Positive(message = "Part id must be positive")
    private Long partId;

    @PositiveOrZero(message = "Price must be positive")
    private Double priceUsed;
}
