package Garage_System.repository;

import Garage_System.entities.JobCardServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCardServiceItemRepository extends JpaRepository<JobCardServiceItem,Long> {
    List<JobCardServiceItem> findByJobCardId(Long id);

    @Query("Select Coalesce(SUM(j.labourFee),0) from JobCardServiceItem j where j.jobCard.id = :jobCardId")
    double sumLabourFeeByJobCardId(@Param("jobCardId") Long jobCardId);
}

