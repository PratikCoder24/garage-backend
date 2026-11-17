package Garage_System.controller;

import Garage_System.DTO.RequestDTO.FuelReadingDetailsRequestDTO;
import Garage_System.DTO.ResponseDTO.FuelReadingResponseDTO;
import Garage_System.service.FuelReadingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/fuel-reading")
@RequiredArgsConstructor
public class FuelReadingController {
    private final FuelReadingService fuelReadingService;

    @GetMapping("/{jobCardId}")
    public ResponseEntity<FuelReadingResponseDTO> getFuelReadingByJobCardId(@PathVariable Long jobCardId){
        return ResponseEntity.ok(fuelReadingService.getFuelReadingByJobCardId(jobCardId));
    }

    @PostMapping("/{jobCardId}/in")
    public ResponseEntity<FuelReadingResponseDTO> saveInReading(
            @PathVariable Long jobCardId,
            @Valid @RequestBody FuelReadingDetailsRequestDTO request
            ){
        FuelReadingResponseDTO response =  fuelReadingService.saveInReading(jobCardId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
