package Garage_System.repository;

import Garage_System.entities.JobCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCardRepository extends JpaRepository<JobCard, Long> {

}
