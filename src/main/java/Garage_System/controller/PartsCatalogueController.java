package Garage_System.controller;

import Garage_System.DTO.RequestDTO.PartsCatalogueRequestDTO;
import Garage_System.DTO.ResponseDTO.PartsCatalogueResponseDTO;
import Garage_System.service.PartsCatalogueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/parts")
@RequiredArgsConstructor
public class PartsCatalogueController {

    private final PartsCatalogueService  partsCatalogueService;

    @GetMapping("/all")
    public ResponseEntity<List<PartsCatalogueResponseDTO>> getAllParts(){
        List<PartsCatalogueResponseDTO> response = partsCatalogueService.getAllParts();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<PartsCatalogueResponseDTO> addParts(
            @Valid @RequestBody PartsCatalogueRequestDTO request
            ){
        PartsCatalogueResponseDTO response = partsCatalogueService.addParts(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PartsCatalogueResponseDTO> updateParts(
            @PathVariable Long id,
            @Valid @RequestBody PartsCatalogueRequestDTO request
    ){
        PartsCatalogueResponseDTO response = partsCatalogueService.updateParts(id,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteParts(@PathVariable Long id){
        partsCatalogueService.deleteParts(id);
        return ResponseEntity.noContent().build();
    }

}
