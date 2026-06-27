package Garage_System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "job_card_parts_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardPartsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "part_id",nullable = false)
    private PartsCatalogue parts;

    @ManyToOne
    @JoinColumn(name = "jobCard_id",nullable = false)
    private JobCard jobCard;

    @Column(name = "price_used",nullable = false)
    private double priceUsed;

    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;
}
