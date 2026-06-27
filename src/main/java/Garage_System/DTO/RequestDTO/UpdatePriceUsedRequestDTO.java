package Garage_System.DTO.RequestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePriceUsedRequestDTO {
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double priceUsed;
}
