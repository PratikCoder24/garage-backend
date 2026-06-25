package Garage_System.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartsCatalogueResponseDTO {
    private Long id;
    private String partsName;
    private double price;
}
