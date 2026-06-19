package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.CustomerRequestDTO;
import Garage_System.DTO.ResponseDTO.CustomerResponseDTO;
import Garage_System.entities.Customer;
import Garage_System.exception.DuplicateResourceException;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.CustomerMapper;
import Garage_System.repository.CustomerRepository;
import Garage_System.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public CustomerResponseDTO addCustomer(CustomerRequestDTO request) {
       Customer customer = new Customer();

       customer.setName(request.getName());
       customer.setAddress(request.getAddress());
       customer.setPhone(request.getPhone());

       Customer savedCustomer = customerRepository.save(customer);
       return CustomerMapper.mapToDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id,CustomerRequestDTO request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not Found"));

        customer.setName(request.getName());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());

        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer =  customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
        customerRepository.delete(customer);
    }
}
