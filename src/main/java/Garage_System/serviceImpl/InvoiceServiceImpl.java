package Garage_System.serviceImpl;

import Garage_System.DTO.ResponseDTO.InvoiceResponseDTO;
import Garage_System.Enum.Status;
import Garage_System.entities.Invoice;
import Garage_System.entities.JobCard;
import Garage_System.entities.JobCardPartsItem;
import Garage_System.entities.JobCardServiceItem;
import Garage_System.exception.DuplicateResourceException;
import Garage_System.exception.InvalidJobCardStateException;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.InvoiceMapper;
import Garage_System.repository.InvoiceRepository;
import Garage_System.repository.JobCardPartsItemRepository;
import Garage_System.repository.JobCardRepository;
import Garage_System.repository.JobCardServiceItemRepository;
import Garage_System.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final JobCardServiceItemRepository jobCardServiceItemRepository;
    private final JobCardPartsItemRepository jobCardPartsItemRepository;
    private final JobCardRepository jobCardRepository;

    @Override
    public InvoiceResponseDTO generateInvoice(Long jobCardId) {
        JobCard jobCard = jobCardRepository.findById(jobCardId)
                .orElseThrow(() -> new ResourceNotFoundException("JobCard not Found!"));
        if(jobCard.getStatus() != Status.COMPLETED){
            throw new InvalidJobCardStateException("Invoice can only be generated for completed job cards.");
        }

        if(invoiceRepository.existsByJobCardId(jobCardId)){
            throw new DuplicateResourceException("Invoice already exists for this job-card!");
        }

        double labourCost = jobCardServiceItemRepository.sumLabourFeeByJobCardId(jobCardId);
        double partsTotal = jobCardPartsItemRepository.sumPriceUsedByJobCardId(jobCardId);

        Invoice invoice = new Invoice();
        invoice.setJobCard(jobCard);
        invoice.setLabourCost(labourCost);
        invoice.setPartsTotal(partsTotal);
        invoice.setTotalAmount(labourCost + partsTotal);
        invoice.setPaymentQr(null);
        invoice.setCreatedAt(LocalDate.now());

        Invoice savedInvoice = invoiceRepository.save(invoice);

        List<JobCardServiceItem> services = jobCardServiceItemRepository.findByJobCardId(jobCardId);

        List<JobCardPartsItem> parts = jobCardPartsItemRepository.findByJobCardId(jobCardId);

        return InvoiceMapper.mapToDTO(savedInvoice,services,parts);
    }

    @Override
    public InvoiceResponseDTO getInvoice(Long invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
        Long jobCardId = invoice.getJobCard().getId();
        List<JobCardServiceItem> services = jobCardServiceItemRepository.findByJobCardId(jobCardId);
        List<JobCardPartsItem> parts = jobCardPartsItemRepository.findByJobCardId(jobCardId);
        return InvoiceMapper.mapToDTO(invoice,services,parts);
    }
}
