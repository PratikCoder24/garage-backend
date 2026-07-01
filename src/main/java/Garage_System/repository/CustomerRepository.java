package Garage_System.repository;

import Garage_System.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByPhoneAndIdNot(String phone, Long id);
    boolean existsByPhone(String phone);

    Optional<Customer> findByPhone(String phone);
}
