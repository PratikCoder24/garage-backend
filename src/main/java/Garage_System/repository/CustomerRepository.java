package Garage_System.repository;

import Garage_System.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByPhoneAndIdNot(String phone, Long id);
    boolean existsByPhone(String phone);
}
