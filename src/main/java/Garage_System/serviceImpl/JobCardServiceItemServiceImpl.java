package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.AddServiceToJobCardRequestDTO;
import Garage_System.DTO.RequestDTO.UpdateLabourFeeRequestDTO;
import Garage_System.DTO.ResponseDTO.JobCardServiceItemResponseDTO;
import Garage_System.entities.JobCard;
import Garage_System.entities.JobCardServiceItem;
import Garage_System.entities.ServiceCatalogue;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.JobCardServiceItemMapper;
import Garage_System.repository.JobCardRepository;
import Garage_System.repository.JobCardServiceItemRepository;
import Garage_System.repository.ServiceCatalogueRepository;
import Garage_System.service.JobCardServiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobCardServiceItemServiceImpl implements JobCardServiceItemService {
    private final JobCardServiceItemRepository jobCardServiceItemRepository;
    private final JobCardRepository jobCardRepository;
    private final ServiceCatalogueRepository serviceRepository;

    @Override
    public List<JobCardServiceItemResponseDTO> getServiceForJobCard(Long jobCardId) {
        JobCard jobCard = jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("JobCard not Found!"));
        return jobCardServiceItemRepository.findByJobCardId(jobCardId)
                .stream()
                .map(JobCardServiceItemMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobCardServiceItemResponseDTO addService(Long jobCardId,AddServiceToJobCardRequestDTO request) {
        JobCard jobCard = jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("JobCard not Found!"));
        ServiceCatalogue service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not Found!"));

        JobCardServiceItem items = new JobCardServiceItem();
        items.setJobCard(jobCard);
        items.setServiceCatalogue(service);
        items.setLabourFee(request.getFee() != null ? request.getFee() : service.getServiceCharge());
        items.setCreatedAt(LocalDate.now());
        JobCardServiceItem savedJobCardServiceItem = jobCardServiceItemRepository.save(items);
        return JobCardServiceItemMapper.mapToDTO(savedJobCardServiceItem);
    }

    @Override
    public JobCardServiceItemResponseDTO updateLabourFee(Long itemId, UpdateLabourFeeRequestDTO request) {
        JobCardServiceItem items = jobCardServiceItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card service item not Found"));
        items.setLabourFee(request.getLabourFee());
        JobCardServiceItem updated = jobCardServiceItemRepository.save(items);
        return JobCardServiceItemMapper.mapToDTO(updated);
    }

    @Override
    public void removeService(Long itemId) {
        JobCardServiceItem item = jobCardServiceItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card service item not Found"));
        jobCardServiceItemRepository.delete(item);
    }

    @Override
    public double getEstimate(Long jobCardId) {
        jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card not Found!"));
        return jobCardServiceItemRepository.sumLabourFeeByJobCardId(jobCardId);
    }
}
