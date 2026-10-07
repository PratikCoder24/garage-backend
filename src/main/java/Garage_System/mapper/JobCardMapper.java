package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.JobCardResponseDTO;
import Garage_System.entities.JobCard;

public class JobCardMapper {
    public static JobCardResponseDTO mapToDTO(JobCard jobCard){
        String customerName = "Unknown Customer";
        if (jobCard.getVehicle() != null && jobCard.getVehicle().getCustomer() != null) {
            customerName = jobCard.getVehicle().getCustomer().getName(); // Adjust getter as per your Entity
        }
        assert jobCard.getVehicle() != null;
        return new JobCardResponseDTO(
                jobCard.getId(),
                jobCard.getCreatedAt(),
                jobCard.getConditionNotes(),
                jobCard.getDeliveryDate(),
                jobCard.getStatus().toString(),
                jobCard.getVehicle().getVehicleNumber(),
                customerName

        );
    }
}