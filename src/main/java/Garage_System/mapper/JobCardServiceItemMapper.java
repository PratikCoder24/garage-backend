package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.JobCardServiceItemResponseDTO;
import Garage_System.entities.JobCardServiceItem;

public class JobCardServiceItemMapper {
    public static JobCardServiceItemResponseDTO mapToDTO(JobCardServiceItem jobCardServiceItem){
        return new JobCardServiceItemResponseDTO(
                jobCardServiceItem.getId(),
                jobCardServiceItem.getJobCard().getId(),
                jobCardServiceItem.getServiceCatalogue().getId(),
                jobCardServiceItem.getServiceCatalogue().getName(),
                jobCardServiceItem.getServiceCatalogue().getServiceCharge(),
                jobCardServiceItem.getLabourFee(),
                jobCardServiceItem.getCreatedAt()
        );
    }
}
