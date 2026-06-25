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
public class PartsCatalogueRequestDTO {
    @NotBlank(message = "Parts name is required!")
    private String partsName;

    @NotNull(message = "Price is required!")
    @PositiveOrZero(message = "Price must be positive")
    private double price;
}
