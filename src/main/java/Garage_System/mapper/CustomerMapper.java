package Garage_System.mapper;

import Garage_System.DTO.ResponseDTO.CustomerResponseDTO;
import Garage_System.entities.Customer;

public class CustomerMapper {
    public static CustomerResponseDTO mapToDTO(Customer customer){
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getPhone()
        );
    }
}
