package Garage_System.controller;

import Garage_System.DTO.RequestDTO.VehicleRequestDTO;
import Garage_System.DTO.ResponseDTO.VehicleResponseDTO;
import Garage_System.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/all")
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles(){
        List<VehicleResponseDTO> response = vehicleService.getAllVehicles();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<VehicleResponseDTO> searchByVehicleNumber(
            @RequestParam String vehicleNumber
    ){
        VehicleResponseDTO response = vehicleService.searchVehicle(vehicleNumber);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<VehicleResponseDTO> addVehicle(
            @Valid @RequestBody VehicleRequestDTO request
            ){
        VehicleResponseDTO response = vehicleService.addVehicle(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleResponseDTO> updateVehicle(
            @PathVariable Long id,
            @Valid @RequestBody VehicleRequestDTO request
    ){
        VehicleResponseDTO response = vehicleService.updateVehicle(id,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();

    }
 }
