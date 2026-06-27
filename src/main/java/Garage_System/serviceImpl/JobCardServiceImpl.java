package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.JobCardRequestDTO;
import Garage_System.DTO.RequestDTO.JobCardStatusUpdateRequestDTO;
import Garage_System.DTO.ResponseDTO.JobCardDetailResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardResponseDTO;
import Garage_System.Enum.Status;
import Garage_System.entities.JobCard;
import Garage_System.entities.JobCardPartsItem;
import Garage_System.entities.JobCardServiceItem;
import Garage_System.entities.Vehicles;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.JobCardDetailMapper;
import Garage_System.mapper.JobCardMapper;
import Garage_System.repository.JobCardPartsItemRepository;
import Garage_System.repository.JobCardRepository;
import Garage_System.repository.JobCardServiceItemRepository;
import Garage_System.repository.VehicleRepository;
import Garage_System.service.JobCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobCardServiceImpl implements JobCardService {
    private final JobCardRepository jobCardRepository;
    private final VehicleRepository vehicleRepository;
    private final JobCardServiceItemRepository jobCardServiceItemRepository;
    private final JobCardPartsItemRepository jobCardPartsItemRepository;

    @Override
    public List<JobCardResponseDTO> getAllJobCards() {
        return jobCardRepository.findAll()
                .stream()
                .map(JobCardMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobCardResponseDTO createJobCard(JobCardRequestDTO request) {
        Vehicles vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not Found!"));
        JobCard jobCard = new JobCard();

        jobCard.setVehicle(vehicle);
        jobCard.setConditionNotes(request.getCondition());
        jobCard.setDeliveryDate(request.getDeliveryDate());
        jobCard.setStatus(Status.RECEIVED);
        jobCard.setCreatedAt(LocalDate.now());

        JobCard savedJobCard = jobCardRepository.save(jobCard);
        return JobCardMapper.mapToDTO(savedJobCard);
    }

    @Override
    public JobCardResponseDTO updateJobCard(Long id, JobCardRequestDTO request) {
        JobCard jobCard = jobCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobCard not Found!"));
        Vehicles vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not Found!"));

        jobCard.setVehicle(vehicle);
        jobCard.setConditionNotes(request.getCondition());
        jobCard.setDeliveryDate(request.getDeliveryDate());
        JobCard updatedJobCard = jobCardRepository.save(jobCard);
        return JobCardMapper.mapToDTO(updatedJobCard);
    }

    @Override
    public JobCardDetailResponseDTO getJobCardById(Long id) {
        JobCard jobCard = jobCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobCard not Found!"));

        List<JobCardServiceItem> serviceItems = jobCardServiceItemRepository.findByJobCardId(id);
        double estimate = jobCardServiceItemRepository.sumLabourFeeByJobCardId(id);

        List<JobCardPartsItem> partItems = jobCardPartsItemRepository.findByJobCardId(id);
        double partsTotal = jobCardPartsItemRepository.sumPriceUsedByJobCardId(id);
        return JobCardDetailMapper.mapToDTO(jobCard,serviceItems,estimate,partItems,partsTotal);
    }

    @Override
    public JobCardResponseDTO updateStatus(Long id, JobCardStatusUpdateRequestDTO request) {
        JobCard jobCard = jobCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobCard not Found!"));
        jobCard.setStatus(request.getStatus());
        JobCard updatedStatus = jobCardRepository.save(jobCard);
        return JobCardMapper.mapToDTO(updatedStatus);
    }
}
