package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.InvoiceResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardPartsItemResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardServiceItemResponseDTO;
import Garage_System.entities.Invoice;
import Garage_System.entities.JobCardPartsItem;
import Garage_System.entities.JobCardServiceItem;

import java.util.List;

public class InvoiceMapper {
    public static InvoiceResponseDTO mapToDTO(
            Invoice invoice,
            List<JobCardServiceItem> services,
            List<JobCardPartsItem> parts
    ){
        List<JobCardServiceItemResponseDTO> serviceDTO = services.stream()
                .map(JobCardServiceItemMapper::mapToDTO)
                .toList();

        List<JobCardPartsItemResponseDTO> partsDTO = parts.stream()
                .map(JobCardPartsItemMapper::mapToDTO)
                .toList();

        return new InvoiceResponseDTO(
                invoice.getId(),
                invoice.getJobCard().getId(),
                serviceDTO,
                invoice.getLabourCost(),
                partsDTO,
                invoice.getPartsTotal(),
                invoice.getTotalAmount(),
                invoice.getPaymentQr(),
                invoice.getCreatedAt()
        );

    }
}
