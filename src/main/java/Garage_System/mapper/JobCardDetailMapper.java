package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.JobCardDetailResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardPartsItemResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardServiceItemResponseDTO;
import Garage_System.entities.JobCard;
import Garage_System.entities.JobCardPartsItem;
import Garage_System.entities.JobCardServiceItem;

import java.util.List;

public class JobCardDetailMapper {

    public static JobCardDetailResponseDTO mapToDTO(
            JobCard jobCard,
            List<JobCardServiceItem> services,
            double estimate,
            List<JobCardPartsItem> parts,
            double partsTotal
    ) {

        List<JobCardServiceItemResponseDTO> serviceDTO =
                services.stream()
                        .map(JobCardServiceItemMapper::mapToDTO)
                        .toList();

        List<JobCardPartsItemResponseDTO> partsDTO =
                parts.stream()
                        .map(JobCardPartsItemMapper::mapToDTO)
                        .toList();

        String customerName = null;

        if (jobCard.getVehicle() != null &&
                jobCard.getVehicle().getCustomer() != null) {

            customerName = jobCard.getVehicle()
                    .getCustomer()
                    .getName();
        }

        double grandTotal = estimate + partsTotal;

        return new JobCardDetailResponseDTO(
                jobCard.getId(),
                jobCard.getCreatedAt(),
                jobCard.getConditionNotes(),
                jobCard.getDeliveryDate(),
                jobCard.getStatus() != null
                        ? jobCard.getStatus().toString()
                        : null,
                jobCard.getVehicle() != null
                        ? jobCard.getVehicle().getVehicleNumber()
                        : null,
                customerName,
                serviceDTO,
                estimate,
                partsDTO,
                partsTotal,
                grandTotal
        );
    }
}