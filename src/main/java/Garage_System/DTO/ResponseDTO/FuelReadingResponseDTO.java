package Garage_System.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuelReadingResponseDTO {
    private Long id;
    private Long jobCardId;

    private FuelReadingDetailsResponseDTO inReading;
}
