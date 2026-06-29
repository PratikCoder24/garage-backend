package Garage_System.repository;

import Garage_System.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    boolean existsByJobCardId(Long jobCardId);
}
