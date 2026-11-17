package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.FuelReadingDetailsRequestDTO;
import Garage_System.DTO.ResponseDTO.FuelReadingResponseDTO;
import Garage_System.Enum.Status;
import Garage_System.entities.FuelReading;
import Garage_System.entities.JobCard;
import Garage_System.exception.DuplicateResourceException;
import Garage_System.exception.InvalidJobCardStateException;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.FuelReadingMapper;
import Garage_System.repository.FuelReadingRepository;
import Garage_System.repository.JobCardRepository;
import Garage_System.service.FuelReadingService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuelReadingServiceImpl implements FuelReadingService {
    private final FuelReadingRepository fuelReadingRepository;
    private final JobCardRepository jobCardRepository;


    @Override
    @Transactional
    public FuelReadingResponseDTO saveInReading(Long jobCardId, FuelReadingDetailsRequestDTO request) {
        JobCard jobCard = jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("JobCard not found!"));

        if(jobCard.getStatus() != Status.RECEIVED && jobCard.getStatus() != Status.IN_PROGRESS) {
               throw new InvalidJobCardStateException("IN reading cannot be saved for this job card status");
        }

        if(fuelReadingRepository.existsByJobCardId(jobCardId)){
            throw new DuplicateResourceException("Fuel reading already exists for this job card");
        }

        FuelReading fuel = new FuelReading();

        fuel.setJobCard(jobCard);
        fuel.setInReading(FuelReadingMapper.mapToEntity(request));

        FuelReading savedReading = fuelReadingRepository.save(fuel);
        return FuelReadingMapper.mapToDTO(savedReading);
    }

    @Override
    @Transactional(readOnly = true)
    public FuelReadingResponseDTO getFuelReadingByJobCardId(Long jobCardId) {
        FuelReading fuelReading = fuelReadingRepository
                .findByJobCardId(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("Fuel reading not found for this job card"));

        return FuelReadingMapper.mapToDTO(fuelReading);
    }
}
