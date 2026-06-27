package Garage_System.repository;

import Garage_System.entities.JobCardPartsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCardPartsItemRepository extends JpaRepository<JobCardPartsItem,Long> {
    List<JobCardPartsItem> findByJobCardId(Long id);

    @Query("Select COALESCE(SUM(j.priceUsed),0) from JobCardPartsItem j where j.jobCard.id = :jobCardId")
    double sumPriceUsedByJobCardId(@Param("jobCardId") Long jobCardId);
}
