package Garage_System.service;

import Garage_System.DTO.RequestDTO.AddPartsToJobCardRequestDTO;
import Garage_System.DTO.RequestDTO.UpdatePriceUsedRequestDTO;
import Garage_System.DTO.ResponseDTO.JobCardPartsItemResponseDTO;
import Garage_System.entities.JobCardPartsItem;

import java.util.List;

public interface JobCardPartsItemService {

    List<JobCardPartsItemResponseDTO> getPartsForJobCard(Long jobCardId);

    JobCardPartsItemResponseDTO addPartsToJobCard(Long jobCardId, AddPartsToJobCardRequestDTO request);

    JobCardPartsItemResponseDTO updatePriceUsed(Long itemId, UpdatePriceUsedRequestDTO request);

    void removePartsFromJobCard(Long itemId);

    double getPartsTotal(Long jobCardId);

}


