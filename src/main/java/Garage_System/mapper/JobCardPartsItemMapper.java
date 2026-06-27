package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.JobCardPartsItemResponseDTO;
import Garage_System.entities.JobCardPartsItem;

public class JobCardPartsItemMapper {
    public static JobCardPartsItemResponseDTO mapToDTO(JobCardPartsItem jobCardPartsItem){
        return new JobCardPartsItemResponseDTO(
                jobCardPartsItem.getId(),
                jobCardPartsItem.getJobCard().getId(),
                jobCardPartsItem.getParts().getId(),
                jobCardPartsItem.getParts().getPartName(),
                jobCardPartsItem.getParts().getPrice(),
                jobCardPartsItem.getPriceUsed(),
                jobCardPartsItem.getCreatedAt()
        );
    }
}
