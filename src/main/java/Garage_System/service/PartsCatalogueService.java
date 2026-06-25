package Garage_System.service;

import Garage_System.DTO.RequestDTO.PartsCatalogueRequestDTO;
import Garage_System.DTO.ResponseDTO.PartsCatalogueResponseDTO;

import java.util.List;

public interface PartsCatalogueService {
    List<PartsCatalogueResponseDTO> getAllParts();

    PartsCatalogueResponseDTO addParts(PartsCatalogueRequestDTO request);

    PartsCatalogueResponseDTO updateParts(Long id,PartsCatalogueRequestDTO request);

    void deleteParts(Long id);
}
