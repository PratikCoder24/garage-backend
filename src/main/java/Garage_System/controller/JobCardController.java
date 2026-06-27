package Garage_System.controller;

import Garage_System.DTO.RequestDTO.*;
import Garage_System.DTO.ResponseDTO.JobCardDetailResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardPartsItemResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardResponseDTO;
import Garage_System.DTO.ResponseDTO.JobCardServiceItemResponseDTO;
import Garage_System.service.JobCardPartsItemService;
import Garage_System.service.JobCardService;
import Garage_System.service.JobCardServiceItemService;
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
    private final JobCardServiceItemService jobCardServiceItemService;
    private final JobCardPartsItemService jobCardPartsItemService;

    @GetMapping("/all")
    public ResponseEntity<List<JobCardResponseDTO>> getAllJobCards(){
        List<JobCardResponseDTO> response = jobCardService.getAllJobCards();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobCardDetailResponseDTO> getJobCardById(@PathVariable Long id){
        JobCardDetailResponseDTO response = jobCardService.getJobCardById(id);
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

    @PostMapping("/{jobCardId}/services")
    public ResponseEntity<JobCardServiceItemResponseDTO> addServiceToJobCard(
            @PathVariable Long jobCardId,
            @Valid @RequestBody AddServiceToJobCardRequestDTO request
            ){
        JobCardServiceItemResponseDTO response = jobCardServiceItemService.addService(jobCardId,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{jobCardId}/services")
    public ResponseEntity<List<JobCardServiceItemResponseDTO>> getServices(@PathVariable Long jobCardId){
        return ResponseEntity.ok(jobCardServiceItemService.getServiceForJobCard(jobCardId));
    }

    @PatchMapping("/services/{itemId}")
    public ResponseEntity<JobCardServiceItemResponseDTO> updateLabourFee(
            @PathVariable Long itemId,
            @Valid @RequestBody UpdateLabourFeeRequestDTO request
            ){
        JobCardServiceItemResponseDTO response = jobCardServiceItemService.updateLabourFee(itemId,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/services/{itemId}")
    public ResponseEntity<Void> removeService(@PathVariable Long itemId){
        jobCardServiceItemService.removeService(itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{jobCardId}/estimate")
    public ResponseEntity<Double> getEstimate(@PathVariable Long jobCardId){
        return ResponseEntity.ok(jobCardServiceItemService.getEstimate(jobCardId));
    }

    @GetMapping("/{jobCardId}/parts")
    public ResponseEntity<List<JobCardPartsItemResponseDTO>> getAllParts(@PathVariable Long jobCardId){
     return ResponseEntity.ok(jobCardPartsItemService.getPartsForJobCard(jobCardId));
    }

    @PostMapping("/{jobCardId}/parts")
    public ResponseEntity<JobCardPartsItemResponseDTO> addPartToJobCard(
            @PathVariable Long jobCardId,
            @Valid @RequestBody AddPartsToJobCardRequestDTO request
            ){
        JobCardPartsItemResponseDTO response = jobCardPartsItemService.addPartsToJobCard(jobCardId,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/parts/{itemId}")
    public ResponseEntity<JobCardPartsItemResponseDTO> updatePriceUsed(
            @PathVariable Long itemId,
            @Valid @RequestBody UpdatePriceUsedRequestDTO request
    ){
        JobCardPartsItemResponseDTO response = jobCardPartsItemService.updatePriceUsed(itemId,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/parts/{itemId}")
    public ResponseEntity<Void> removePartsFromJobCard(@PathVariable Long itemId){
        jobCardPartsItemService.removePartsFromJobCard(itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{jobCardId}/parts-total")
    public ResponseEntity<Double> getPartsTotal(@PathVariable Long jobCardId){
        double response = jobCardPartsItemService.getPartsTotal(jobCardId);
        return ResponseEntity.ok(response);
    }
}
