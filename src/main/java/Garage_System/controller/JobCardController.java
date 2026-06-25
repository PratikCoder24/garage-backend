package Garage_System.controller;

import Garage_System.DTO.RequestDTO.JobCardRequestDTO;
import Garage_System.DTO.RequestDTO.JobCardStatusUpdateRequestDTO;
import Garage_System.DTO.ResponseDTO.JobCardResponseDTO;
import Garage_System.service.JobCardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/job-card")
@RequiredArgsConstructor
public class JobCardController {

    private final JobCardService jobCardService;

    @GetMapping("/all")
    public ResponseEntity<List<JobCardResponseDTO>> getAllJobCards(){
        List<JobCardResponseDTO> response = jobCardService.getAllJobCards();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobCardResponseDTO> getJobCardById(@PathVariable Long id){
        JobCardResponseDTO response = jobCardService.getJobCardById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<JobCardResponseDTO> createJobCard(
            @Valid @RequestBody JobCardRequestDTO request
            ){
        JobCardResponseDTO response = jobCardService.createJobCard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JobCardResponseDTO> updateJobCard(
            @PathVariable Long id,
            @Valid @RequestBody JobCardRequestDTO request
    ){
        JobCardResponseDTO response = jobCardService.updateJobCard(id,request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<JobCardResponseDTO> updateJobCardStatus(
            @PathVariable Long id,
            @Valid @RequestBody JobCardStatusUpdateRequestDTO request
    ){
        JobCardResponseDTO response = jobCardService.updateStatus(id,request);
        return ResponseEntity.ok(response);
    }
}
