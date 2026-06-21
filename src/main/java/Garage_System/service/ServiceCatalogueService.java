package Garage_System.service;

import Garage_System.DTO.RequestDTO.ServiceCatalogueRequestDTO;
import Garage_System.DTO.ResponseDTO.ServiceCatalogueResponseDTO;

import java.util.List;

public interface ServiceCatalogueService {
    ServiceCatalogueResponseDTO addService(ServiceCatalogueRequestDTO request);

    List<ServiceCatalogueResponseDTO> getAllService();

    ServiceCatalogueResponseDTO updateService(Long id, ServiceCatalogueRequestDTO request);

    void deleteService(Long id);
}
