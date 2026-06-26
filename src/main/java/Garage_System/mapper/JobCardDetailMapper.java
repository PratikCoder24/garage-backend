package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.JobCardDetailResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardServiceItemResponseDTO;
import Garage_System.entities.JobCard;
import Garage_System.entities.JobCardServiceItem;

import java.util.List;

public class JobCardDetailMapper {
    public static JobCardDetailResponseDTO mapToDTO(
            JobCard jobCard,
            List<JobCardServiceItem> services,
            double estimate
    ){
        List<JobCardServiceItemResponseDTO> serviceDTO = services.stream()
                .map(JobCardServiceItemMapper::mapToDTO)
                .toList();

        return new JobCardDetailResponseDTO(
                jobCard.getId(),
                jobCard.getCreatedAt(),
                jobCard.getConditionNotes(),
                jobCard.getDeliveryDate().toString(),
                jobCard.getStatus().toString(),
                jobCard.getVehicle().getVehicleNumber(),
                serviceDTO,
                estimate

        );
    }
}
