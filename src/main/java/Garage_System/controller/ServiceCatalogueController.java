package Garage_System.controller;

import Garage_System.DTO.RequestDTO.ServiceCatalogueRequestDTO;
import Garage_System.DTO.ResponseDTO.ServiceCatalogueResponseDTO;
import Garage_System.service.ServiceCatalogueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/service")
@RequiredArgsConstructor
public class ServiceCatalogueController {
    private final ServiceCatalogueService service;

    @GetMapping("/all")
    public ResponseEntity<List<ServiceCatalogueResponseDTO>> getAllService(){
        List<ServiceCatalogueResponseDTO> response = service.getAllService();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<ServiceCatalogueResponseDTO> addService(
            @Valid @RequestBody ServiceCatalogueRequestDTO request
            ){
        ServiceCatalogueResponseDTO response = service.addService(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceCatalogueResponseDTO> updateService(
            @PathVariable Long id,
            @Valid @RequestBody ServiceCatalogueRequestDTO request
    ){
        ServiceCatalogueResponseDTO response = service.updateService(id,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id){
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
