package Garage_System.repository;

import Garage_System.entities.JobCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobCardRepository extends JpaRepository<JobCard, Long> {
    @Query("""
        SELECT DISTINCT j
        FROM JobCard j
        LEFT JOIN FETCH j.vehicle v
        LEFT JOIN FETCH v.customer
        LEFT JOIN FETCH j.jobCardServiceItemList s
        LEFT JOIN FETCH s.serviceCatalogue
        LEFT JOIN FETCH j.jobCardPartsItemsList p
        LEFT JOIN FETCH p.parts
        WHERE j.id = :id
    """)
    Optional<JobCard> findJobCardWithDetailsById(@Param("id") Long id);

}
