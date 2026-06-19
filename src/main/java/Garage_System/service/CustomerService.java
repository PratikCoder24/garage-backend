package Garage_System.service;

import Garage_System.DTO.RequestDTO.CustomerRequestDTO;
import Garage_System.DTO.ResponseDTO.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO addCustomer(CustomerRequestDTO request);

    CustomerResponseDTO updateCustomer(Long id,CustomerRequestDTO request);

    List<CustomerResponseDTO> getAllCustomers();

    void deleteCustomer(Long id);
}
