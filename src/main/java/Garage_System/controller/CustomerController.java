package Garage_System.controller;

import Garage_System.DTO.RequestDTO.CustomerRequestDTO;
import Garage_System.DTO.ResponseDTO.CustomerResponseDTO;
import Garage_System.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
        List<CustomerResponseDTO> responseDTO = customerService.getAllCustomers();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/phone")
    public ResponseEntity<Boolean> getCustomerByPhone(
            @RequestParam String phone
    ){
        return ResponseEntity.ok(customerService.getCustomerByPhone(phone));
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerResponseDTO> addCustomer(
            @Valid @RequestBody CustomerRequestDTO request
            ){
        CustomerResponseDTO response = customerService.addCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerRequestDTO request
    ){
        CustomerResponseDTO response = customerService.updateCustomer(id,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable Long id
    ){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
