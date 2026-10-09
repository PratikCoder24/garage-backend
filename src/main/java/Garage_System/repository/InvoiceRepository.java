package Garage_System.repository;

import Garage_System.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    boolean existsByJobCardId(Long jobCardId);
    Optional<Invoice> findByJobCardId(Long jobCardId);
}
