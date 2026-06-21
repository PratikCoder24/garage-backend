package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.ServiceCatalogueResponseDTO;
import Garage_System.entities.ServiceCatalogue;

public class ServiceCatalogueMapper {
    public static ServiceCatalogueResponseDTO mapToDTO(ServiceCatalogue service){
        return new ServiceCatalogueResponseDTO(
                service.getId(),
                service.getName(),
                service.getServiceCharge()
        );
    }
}
