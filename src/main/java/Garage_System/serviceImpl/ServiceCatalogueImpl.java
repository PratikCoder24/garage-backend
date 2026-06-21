package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.ServiceCatalogueRequestDTO;
import Garage_System.DTO.ResponseDTO.ServiceCatalogueResponseDTO;
import Garage_System.entities.ServiceCatalogue;
import Garage_System.exception.DuplicateResourceException;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.ServiceCatalogueMapper;
import Garage_System.repository.ServiceCatalogueRepository;
import Garage_System.service.ServiceCatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceCatalogueImpl implements ServiceCatalogueService {
    private final ServiceCatalogueRepository repository;

    @Override
    public ServiceCatalogueResponseDTO addService(ServiceCatalogueRequestDTO request) {
        if(repository.existsByName(request.getServiceName())){
            throw new DuplicateResourceException("Service with this name already exists!");
        }
        ServiceCatalogue service = new ServiceCatalogue();

        service.setName(request.getServiceName());
        service.setServiceCharge(request.getServiceCharge());

        ServiceCatalogue savedService = repository.save(service);

        return ServiceCatalogueMapper.mapToDTO(savedService);
    }

    @Override
    public List<ServiceCatalogueResponseDTO> getAllService() {
        return repository.findAll()
                .stream()
                .map(ServiceCatalogueMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceCatalogueResponseDTO updateService(Long id, ServiceCatalogueRequestDTO request) {
        ServiceCatalogue service = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not Found!"));

        if(repository.existsByNameAndIdNot(request.getServiceName(),id)){
            throw new DuplicateResourceException("Service with this name already exists!");
        }

        service.setName(request.getServiceName());
        service.setServiceCharge(request.getServiceCharge());

        ServiceCatalogue savedService = repository.save(service);
        return ServiceCatalogueMapper.mapToDTO(savedService);
    }

    @Override
    public void deleteService(Long id) {
        ServiceCatalogue service = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not Found"));
        repository.delete(service);
    }
}
