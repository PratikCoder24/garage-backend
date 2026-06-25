package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.JobCardResponseDTO;
import Garage_System.entities.JobCard;

public class JobCardMapper {
    public static JobCardResponseDTO mapToDTO(JobCard jobCard){
        return new JobCardResponseDTO(
                jobCard.getId(),
                jobCard.getCreatedAt(),
                jobCard.getConditionNotes(),
                jobCard.getDeliveryDate(),
                jobCard.getStatus().toString(),
                jobCard.getVehicle().getVehicleNumber()

        );
    }
}
