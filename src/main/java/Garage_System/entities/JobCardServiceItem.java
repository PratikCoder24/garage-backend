package Garage_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "jobcard_service_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardServiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_id",nullable = false)
    private ServiceCatalogue serviceCatalogue;

    @ManyToOne
    @JoinColumn(name = "jobCard_id",nullable = false)
    private JobCard jobCard;

    @Column(name = "labour_fee",nullable = false)
    private double labourFee;

    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;
}
