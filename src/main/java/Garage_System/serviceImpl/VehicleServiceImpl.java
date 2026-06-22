package Garage_System.serviceImpl;

import Garage_System.DTO.RequestDTO.VehicleRequestDTO;
import Garage_System.DTO.ResponseDTO.VehicleResponseDTO;
import Garage_System.entities.Customer;
import Garage_System.entities.Vehicles;
import Garage_System.exception.DuplicateResourceException;
import Garage_System.exception.ResourceNotFoundException;
import Garage_System.mapper.VehicleMapper;
import Garage_System.repository.CustomerRepository;
import Garage_System.repository.VehicleRepository;
import Garage_System.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;


    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleMapper :: mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponseDTO addVehicle(VehicleRequestDTO request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not Found"));
        if(vehicleRepository.existsByVehicleNumber(request.getVehicleNumber())){
            throw new DuplicateResourceException("Vehicle already exists!");
        }

        if(vehicleRepository.existsByChassisNumber(request.getChassisNumber())){
            throw new DuplicateResourceException("Vehicle already exists!");
        }

        Vehicles vehicle = new Vehicles();

        vehicle.setCustomer(customer);
        vehicle.setModel(request.getModel());
        vehicle.setCompany(request.getCompanyName());
        vehicle.setVehicleNumber(request.getVehicleNumber());
        vehicle.setChassisNumber(request.getChassisNumber());
        vehicle.setEngineNumber(request.getEngineNumber());
        vehicle.setOdometer(request.getOdometer());

        Vehicles savedVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToDTO(savedVehicle);
    }

    @Override
    public VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not Found"));
        Vehicles vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not Found!"));
        if(vehicleRepository.existsByVehicleNumberAndIdNot(request.getVehicleNumber(),id)){
            throw new DuplicateResourceException("Vehicle already exists!");
        }

        if(vehicleRepository.existsByChassisNumberAndIdNot(request.getChassisNumber(),id)){
            throw  new DuplicateResourceException("Vehicle already exists!");
        }

        vehicle.setModel(request.getModel());
        vehicle.setCustomer(customer);
        vehicle.setCompany(request.getCompanyName());
        vehicle.setVehicleNumber(request.getVehicleNumber());
        vehicle.setChassisNumber(request.getChassisNumber());
        vehicle.setEngineNumber(request.getEngineNumber());
        vehicle.setOdometer(request.getOdometer());

        Vehicles updatedVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToDTO(updatedVehicle);
    }

    @Override
    public VehicleResponseDTO searchVehicle(String vehicleNumber) {

        Vehicles vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber)
               .orElseThrow(() -> new ResourceNotFoundException("Vehicle not Found!"));

       return VehicleMapper.mapToDTO(vehicle)   ;
    }


    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not Found!"));
         vehicleRepository.deleteById(id);
    }
}
