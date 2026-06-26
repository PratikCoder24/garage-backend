package Garage_System.service;

import Garage_System.DTO.RequestDTO.AddServiceToJobCardRequestDTO;
import Garage_System.DTO.RequestDTO.UpdateLabourFeeRequestDTO;
import Garage_System.DTO.ResponseDTO.JobCardServiceItemResponseDTO;

import java.util.List;

public interface JobCardServiceItemService {
    List<JobCardServiceItemResponseDTO> getServiceForJobCard(Long jobCardId);

    JobCardServiceItemResponseDTO addService(Long jobCardId,AddServiceToJobCardRequestDTO request);

    JobCardServiceItemResponseDTO updateLabourFee(Long itemId, UpdateLabourFeeRequestDTO request);

    void removeService(Long itemId);

    double getEstimate(Long jobCardId);
}
