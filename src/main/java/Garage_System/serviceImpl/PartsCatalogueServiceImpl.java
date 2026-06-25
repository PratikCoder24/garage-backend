package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.PartsCatalogueRequestDTO;
import Garage_System.DTO.ResponseDTO.PartsCatalogueResponseDTO;
import Garage_System.entities.PartsCatalogue;
import Garage_System.exception.DuplicateResourceException;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.PartsCatalogueMapper;
import Garage_System.repository.PartsCatalogueRepository;
import Garage_System.service.PartsCatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartsCatalogueServiceImpl implements PartsCatalogueService {
    private final PartsCatalogueRepository partsCatalogueRepository;

    @Override
    public List<PartsCatalogueResponseDTO> getAllParts() {
        return partsCatalogueRepository.findAll()
                .stream()
                .map(PartsCatalogueMapper :: mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PartsCatalogueResponseDTO addParts(PartsCatalogueRequestDTO request) {
        if(partsCatalogueRepository.existsByPartName(request.getPartsName())){
            throw new DuplicateResourceException("Part with this name already exists!");
        }

        PartsCatalogue parts = new PartsCatalogue();
        parts.setPartName(request.getPartsName());
        parts.setPrice(request.getPrice());
        PartsCatalogue savedParts = partsCatalogueRepository.save(parts);
        return PartsCatalogueMapper.mapToDTO(savedParts);
    }

    @Override
    public PartsCatalogueResponseDTO updateParts(Long id, PartsCatalogueRequestDTO request) {
        PartsCatalogue parts = partsCatalogueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part not Found!"));
        if(partsCatalogueRepository.existsByPartNameAndIdNot(request.getPartsName(),id)){
            throw new DuplicateResourceException("Part with this name already exists!");
        }

        parts.setPartName(request.getPartsName());
        parts.setPrice(request.getPrice());
        PartsCatalogue savedParts = partsCatalogueRepository.save(parts);
        return PartsCatalogueMapper.mapToDTO(savedParts);
    }

    @Override
    public void deleteParts(Long id) {
        PartsCatalogue parts = partsCatalogueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part not Found!"));
        partsCatalogueRepository.deleteById(id);
    }
}
