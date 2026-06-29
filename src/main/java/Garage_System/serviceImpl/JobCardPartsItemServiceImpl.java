package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.AddPartsToJobCardRequestDTO;
import Garage_System.DTO.RequestDTO.UpdatePriceUsedRequestDTO;
import Garage_System.DTO.ResponseDTO.JobCardPartsItemResponseDTO;
import Garage_System.entities.JobCard;
import Garage_System.entities.JobCardPartsItem;
import Garage_System.entities.PartsCatalogue;
import Garage_System.exception.InvalidJobCardStateException;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.JobCardPartsItemMapper;
import Garage_System.repository.InvoiceRepository;
import Garage_System.repository.JobCardPartsItemRepository;
import Garage_System.repository.JobCardRepository;
import Garage_System.repository.PartsCatalogueRepository;
import Garage_System.service.JobCardPartsItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobCardPartsItemServiceImpl implements JobCardPartsItemService {
    private final JobCardPartsItemRepository jobCardPartsItemRepository;
    private final JobCardRepository jobCardRepository;
    private final PartsCatalogueRepository partsRepository;
    private final InvoiceRepository invoiceRepository;


    @Override
    public List<JobCardPartsItemResponseDTO> getPartsForJobCard(Long jobCardId) {
           jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card not Found!"));
        return jobCardPartsItemRepository.findByJobCardId(jobCardId)
                .stream()
                .map(JobCardPartsItemMapper::mapToDTO)
                .toList();
    }

    @Override
    public JobCardPartsItemResponseDTO addPartsToJobCard(Long jobCardId, AddPartsToJobCardRequestDTO request) {
        JobCard jobCard = jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card not Found"));
        PartsCatalogue parts = partsRepository.findById(request.getPartId())
                .orElseThrow(() -> new ResourceNotFoundException("Parts not Found!"));
        if(invoiceRepository.existsByJobCardId(jobCardId)){
            throw new InvalidJobCardStateException("Cannot modify a job card that has already been invoiced");
        }
        JobCardPartsItem items = new JobCardPartsItem();
        items.setJobCard(jobCard);
        items.setParts(parts);
        items.setPriceUsed(request.getPriceUsed() != null ? request.getPriceUsed() : parts.getPrice());
        items.setCreatedAt(LocalDate.now());

        JobCardPartsItem savedItems = jobCardPartsItemRepository.save(items);
        return JobCardPartsItemMapper.mapToDTO(savedItems);
    }

    @Override
    public JobCardPartsItemResponseDTO updatePriceUsed(Long itemId, UpdatePriceUsedRequestDTO request) {
        JobCardPartsItem items = jobCardPartsItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card parts item not Found!"));
        if(invoiceRepository.existsByJobCardId(items.getJobCard().getId())){
            throw new InvalidJobCardStateException("Cannot modify a job card that has already been invoiced");
        }
        items.setPriceUsed(request.getPriceUsed());
        JobCardPartsItem updatedItems = jobCardPartsItemRepository.save(items);
        return JobCardPartsItemMapper.mapToDTO(updatedItems);
    }

    @Override
    public void removePartsFromJobCard(Long itemId) {
        JobCardPartsItem item = jobCardPartsItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card parts item not Found!"));
        if(invoiceRepository.existsByJobCardId(item.getJobCard().getId())){
            throw new InvalidJobCardStateException("Cannot modify a job card that has already been invoiced");
        }
        jobCardPartsItemRepository.delete(item);
    }

    @Override
    public double getPartsTotal(Long jobCardId) {
         jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("Job card not Found"));
        return jobCardPartsItemRepository.sumPriceUsedByJobCardId(jobCardId);
    }

}
