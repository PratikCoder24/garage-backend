package Garage_System.service;

import Garage_System.DTO.RequestDTO.JobCardRequestDTO;
import Garage_System.DTO.RequestDTO.JobCardStatusUpdateRequestDTO;
import Garage_System.DTO.ResponseDTO.JobCardResponseDTO;

import java.util.List;

public interface JobCardService {
    List<JobCardResponseDTO> getAllJobCards();

    JobCardResponseDTO createJobCard(JobCardRequestDTO request);

    JobCardResponseDTO updateJobCard(Long id,JobCardRequestDTO request);

    JobCardResponseDTO getJobCardById(Long id);

    JobCardResponseDTO updateStatus(Long id, JobCardStatusUpdateRequestDTO request);

}
