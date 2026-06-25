package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.PartsCatalogueResponseDTO;
import Garage_System.entities.PartsCatalogue;

public class PartsCatalogueMapper {
    public static PartsCatalogueResponseDTO mapToDTO(PartsCatalogue partsCatalogue){
        return new PartsCatalogueResponseDTO(
                partsCatalogue.getId(),
                partsCatalogue.getPartName(),
                partsCatalogue.getPrice()
        );
    }
}
